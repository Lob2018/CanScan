/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import fr.softsf.canscan.model.VersionValue;
import fr.softsf.canscan.util.Checker;

/**
 * Service for checking if the application version is up to date by querying the GitHub API. It
 * retrieves the latest release tag from the repository and compares it with the current application
 * version.
 */
public enum VersionService {
    INSTANCE;

    private static final String GITHUB_TAGS_API_URL =
            "https://api.github.com/repos/Lob2018/CanScan/tags";
    private static final String LATEST_RELEASES_REPO_URL =
            "Lien : https://github.com/Lob2018/CanScan/releases/latest";
    private static final int HTTP_STATUS_OK = 200;
    private static final int MAX_TAGS_RESPONSE_SIZE = 65_536;
    private static final int MAX_TAG_NAME_LENGTH = 256;
    private static final String TOOLTIP_PREFIX = "Mise à jour :<br>";
    private static final String CLOSE_HTML = "</html>";
    private static final String OPEN_HTML = "<html>";
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_NOT_FOUND = 404;

    private final HttpClient httpClient;

    /** Enum constructor initializing the infrastructure. */
    VersionService() {
        this.httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    }

    /**
     * Checks if the current application version matches the latest release on GitHub.
     *
     * @param currentVersion Current application version
     * @param updateButton Target button for state updates
     * @return a {@link SwingWorker} returning a {@link VersionValue}
     */
    public SwingWorker<VersionValue, Void> checkLatestVersion(
            String currentVersion, JButton updateButton) {
        if (Checker.INSTANCE.checkNPE(currentVersion, "checkLatestVersion", "currentVersion")
                || Checker.INSTANCE.checkNPE(updateButton, "checkLatestVersion", "updateButton")) {
            return new SwingWorker<>() {
                @Override
                protected VersionValue doInBackground() {
                    return new VersionValue(0, "Paramètre manquant.", null, true);
                }

                @Override
                protected void done() {
                    updateButtonState(
                            updateButton,
                            false,
                            OPEN_HTML
                                    + TOOLTIP_PREFIX
                                    + "Erreur interne.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                }
            };
        }

        return new SwingWorker<>() {
            @Override
            protected VersionValue doInBackground() {
                try {
                    HttpRequest request =
                            HttpRequest.newBuilder()
                                    .uri(URI.create(GITHUB_TAGS_API_URL))
                                    .header("Accept", "application/json")
                                    .header("User-Agent", "CanScan")
                                    .timeout(Duration.ofSeconds(5))
                                    .GET()
                                    .build();
                    HttpResponse<InputStream> response =
                            httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
                    if (response.statusCode() != HTTP_STATUS_OK) {
                        String msg =
                                switch (response.statusCode()) {
                                    case HTTP_FORBIDDEN -> "Limite d'API GitHub atteinte (403).";
                                    case HTTP_NOT_FOUND -> "Dépôt introuvable (404).";
                                    default ->
                                            "Erreur serveur GitHub (Code : "
                                                    + response.statusCode()
                                                    + ").";
                                };
                        return new VersionValue(response.statusCode(), msg, null, true);
                    }
                    try (InputStream is = response.body()) {
                        byte[] data = is.readNBytes(MAX_TAGS_RESPONSE_SIZE);
                        return parseResponse(data, currentVersion.replaceFirst("^v", ""));
                    }
                } catch (HttpTimeoutException _) {
                    return new VersionValue(0, "Le délai d'attente est dépassé.", null, true);
                } catch (IOException e) {
                    return new VersionValue(0, "Erreur réseau : " + e.getMessage(), null, true);
                } catch (InterruptedException _) {
                    Thread.currentThread().interrupt();
                    return new VersionValue(0, "Vérification interrompue.", null, true);
                }
            }

            @Override
            protected void done() {
                try {
                    VersionValue result = get();
                    boolean hasUpdate =
                            !result.isUpToDate() && result.statusCode() == HTTP_STATUS_OK;
                    updateButtonState(
                            updateButton,
                            hasUpdate,
                            OPEN_HTML
                                    + TOOLTIP_PREFIX
                                    + result.statusMessage()
                                    + "<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                } catch (InterruptedException _) {
                    Thread.currentThread().interrupt();
                    updateButtonState(
                            updateButton,
                            false,
                            OPEN_HTML
                                    + TOOLTIP_PREFIX
                                    + "Vérification annulée.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                } catch (ExecutionException _) {
                    updateButtonState(
                            updateButton,
                            false,
                            OPEN_HTML
                                    + TOOLTIP_PREFIX
                                    + "Impossible de vérifier la version.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                }
            }
        };
    }

    /**
     * Parses the byte array directly using Gson.
     *
     * @param data the byte array containing the JSON response
     * @param cleanCurrentVersion the current version without prefix
     * @return an evaluated {@link VersionValue}
     */
    @SuppressFBWarnings(
            value = "REC_CATCH_EXCEPTION",
            justification =
                    "Captures all exceptions to ensure robust handling of unexpected Gson runtime"
                            + " errors and malformed external JSON structures.")
    private VersionValue parseResponse(byte[] data, String cleanCurrentVersion) {
        if (data.length == 0) {
            return new VersionValue(HTTP_STATUS_OK, "Réponse vide.", null, true);
        }
        try (Reader reader =
                new InputStreamReader(new ByteArrayInputStream(data), StandardCharsets.UTF_8)) {
            JsonElement rootElement = JsonParser.parseReader(reader);
            if (rootElement == null || !rootElement.isJsonArray()) {
                return new VersionValue(HTTP_STATUS_OK, "Aucun tag trouvé.", null, true);
            }
            JsonArray root = rootElement.getAsJsonArray();
            if (root.isEmpty()) {
                return new VersionValue(HTTP_STATUS_OK, "Aucun tag trouvé.", null, true);
            }
            JsonElement firstObj = root.get(0);
            if (firstObj == null || !firstObj.isJsonObject()) {
                return new VersionValue(HTTP_STATUS_OK, "Tag invalide.", null, true);
            }
            JsonObject firstTagObj = firstObj.getAsJsonObject();
            if (!firstTagObj.has("name") || !firstTagObj.get("name").isJsonPrimitive()) {
                return new VersionValue(HTTP_STATUS_OK, "Tag invalide.", null, true);
            }
            String rawTag = firstTagObj.get("name").getAsString();
            if (rawTag.length() > MAX_TAG_NAME_LENGTH) {
                return new VersionValue(HTTP_STATUS_OK, "Nom de tag trop long.", null, true);
            }
            String latestVersion = rawTag.replaceFirst("^v", "").trim();
            boolean upToDate = cleanCurrentVersion.equals(latestVersion);
            return new VersionValue(
                    HTTP_STATUS_OK,
                    upToDate ? "Votre version est à jour." : "Une nouvelle version est disponible.",
                    rawTag,
                    upToDate);
        } catch (Exception _) {
            return new VersionValue(HTTP_STATUS_OK, "Erreur d'analyse du JSON.", null, true);
        }
    }

    /** Updates the UI button state. */
    private void updateButtonState(JButton button, boolean enabled, String tooltip) {
        if (button != null) {
            button.setEnabled(enabled);
            button.setToolTipText(tooltip);
        }
    }
}
