/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import fr.softsf.canscan.constant.StringConstants;
import fr.softsf.canscan.model.VersionValue;
import fr.softsf.canscan.ui.MyPopup;
import fr.softsf.canscan.util.Checker;

/**
 * Singleton service for checking application version against GitHub releases. Uses the GitHub API
 * to compare the current version with the latest tagged release.
 */
public enum VersionService {
    INSTANCE;

    private static final String GITHUB_TAGS_API_URL =
            "https://api.github.com/repos/Lob2018/CanScan/tags";
    private static final Pattern TAG_PATTERN = Pattern.compile("\"name\"\\s*:\\s*\"([^\"]+)\"");
    private static final int HTTP_STATUS_CODE_OK = 200;
    private static final String LATEST_RELEASES_REPO_URL =
            "https://github.com/Lob2018/CanScan/releases/latest";
    private static final String CLOSE_HTML = "</html>";
    private final HttpClient httpClient;

    /**
     * Initializes the HTTP client with TLS 1.3 and 5-second timeout. Sets httpClient to null if
     * initialization fails.
     */
    VersionService() {
        HttpClient client = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(null, null, null);
            client =
                    HttpClient.newBuilder()
                            .sslContext(sslContext)
                            .connectTimeout(Duration.ofSeconds(5))
                            .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            MyPopup.INSTANCE.showDialog(
                    "TLS 1.3 est requis mais non disponible.\n",
                    e.getMessage(),
                    StringConstants.ERREUR.getValue());
        } catch (UncheckedIOException | SecurityException e) {
            MyPopup.INSTANCE.showDialog(
                    "Impossible de créer HTTP client.\n",
                    e.getMessage(),
                    StringConstants.ERREUR.getValue());
        }
        this.httpClient = client;
    }

    /**
     * Asynchronously checks for updates and returns detailed version metadata.
     *
     * @param currentVersion Current application version.
     * @param updateButton Target button for state updates.
     * @return A SwingWorker providing the complete VersionValue result.
     */
    public SwingWorker<VersionValue, Void> checkLatestVersion(
            String currentVersion, JButton updateButton) {
        SwingWorker<VersionValue, Void> npe = npeCheckLatestVersion(currentVersion, updateButton);
        if (npe != null) {
            return npe;
        }
        return new SwingWorker<>() {
            @Override
            protected VersionValue doInBackground() {
                try {
                    return requestAndVerify(currentVersion);
                } catch (IOException e) {
                    return new VersionValue(
                            0,
                            e.getMessage() == null
                                    ? "Erreur réseau"
                                    : "Erreur réseau : " + e.getMessage(),
                            null,
                            true);
                } catch (InterruptedException _) {
                    Thread.currentThread().interrupt();
                    return new VersionValue(0, "Vérification interrompue", null, true);
                }
            }

            @Override
            protected void done() {
                try {
                    VersionValue result = get();
                    updateButtonState(
                            updateButton,
                            !result.isUpToDate() && result.statusCode() == HTTP_STATUS_CODE_OK,
                            "<html>"
                                    + result.statusMessage()
                                    + "<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                } catch (InterruptedException _) {
                    Thread.currentThread().interrupt();
                    updateButtonState(
                            updateButton,
                            false,
                            "<html>Vérification de la mise à jour interrompue.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                } catch (ExecutionException _) {
                    updateButtonState(
                            updateButton,
                            false,
                            "<html>Vérification de la mise à jour non réalisée.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                }
            }
        };
    }

    /**
     * Performs synchronous HTTP resolution and evaluates the version state.
     *
     * @param currentVersion Application version string to compare against.
     * @return A {@code VersionValue} mapping the HTTP outcome to update logic.
     * @throws IOException If a network or protocol error occurs.
     * @throws InterruptedException If the operation is canceled during execution.
     */
    private VersionValue requestAndVerify(String currentVersion)
            throws IOException, InterruptedException {
        if (httpClient == null) {
            return new VersionValue(0, "HTTP client non initialisé.", null, true);
        }
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(GITHUB_TAGS_API_URL))
                        .timeout(Duration.ofSeconds(5))
                        .header("User-Agent", "CanScan")
                        .GET()
                        .build();
        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int code = response.statusCode();
        return switch (code) {
            case HTTP_STATUS_CODE_OK -> {
                Matcher matcher = TAG_PATTERN.matcher(response.body());
                if (matcher.find()) {
                    String latestTag = matcher.group(1).trim();
                    boolean upToDate = latestTag.equalsIgnoreCase("v" + currentVersion);
                    yield new VersionValue(
                            code,
                            upToDate
                                    ? "Votre version est à jour (" + latestTag + ")."
                                    : "Nouvelle version disponible : " + latestTag + ".",
                            latestTag,
                            upToDate);
                }
                yield new VersionValue(code, "Échec de l'analyse du tag en local.", null, true);
            }
            case 403 ->
                    new VersionValue(
                            code,
                            "Limite de requêtes API GitHub atteinte (code HTTP:403).",
                            null,
                            true);
            case 404 ->
                    new VersionValue(
                            code, "Dépôt introuvable sur GitHub (code HTTP:404).", null, true);
            default ->
                    new VersionValue(
                            code,
                            "Erreur lors de la vérification (code HTTP: " + code + ").",
                            null,
                            true);
        };
    }

    /**
     * Validates inputs and provides a fallback worker if parameters are missing.
     *
     * @param currentVersion Application version string.
     * @param updateButton UI button reference.
     * @return Fallback SwingWorker or null if validation passes.
     */
    private SwingWorker<VersionValue, Void> npeCheckLatestVersion(
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
                            "<html>Il manque un paramètre dans checkLatestVersion pour vérifier la"
                                    + " mise à jour.<br>"
                                    + LATEST_RELEASES_REPO_URL
                                    + CLOSE_HTML);
                }
            };
        }
        return null;
    }

    /**
     * Updates the state and tooltip of the given button based on application logic.
     *
     * @param button the JButton to update
     * @param enabled whether the button should be enabled
     * @param tooltip the tooltip text to display on hover
     */
    private void updateButtonState(JButton button, boolean enabled, String tooltip) {
        button.setEnabled(enabled);
        button.setToolTipText(tooltip);
    }
}
