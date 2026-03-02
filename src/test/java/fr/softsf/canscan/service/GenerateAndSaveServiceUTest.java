/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.service;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;

import fr.softsf.canscan.ui.EncodedImage;
import fr.softsf.canscan.ui.MyPopup;
import fr.softsf.canscan.util.FrameHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/** Suite de tests unitaires pour le service de génération et de sauvegarde des fichiers QR. */
@DisplayName("*** Generate and save service tests ***")
class GenerateAndSaveServiceUTest {

    private GenerateAndSaveService qrService;

    @TempDir File tempDir;

    /** Initialisation du service avec un mock pour la partie rendu d'image. */
    @BeforeEach
    void setUp() {
        EncodedImage encodedImage = mock(EncodedImage.class);
        qrService = new GenerateAndSaveService(encodedImage);
    }

    /** Vérifie que l'extension .png est conservée si elle est déjà présente. */
    @Test
    @DisplayName("FILE : Conservation de l'extension .png existante")
    void givenFileWithPngExtension_whenGetSelectedPngFile_thenReturnSameFile() {
        JFileChooser chooser = mock(JFileChooser.class);
        File testFile = new File(tempDir, "test.png");
        when(chooser.getSelectedFile()).thenReturn(testFile);
        File result = qrService.getSelectedFileForTests(chooser);
        assertTrue(result.getName().endsWith(".png"));
    }

    /** Vérifie l'ajout automatique de l'extension .png si elle est absente lors de la sélection. */
    @Test
    @DisplayName("FILE : Ajout automatique de l'extension .png manquante")
    void givenFileWithoutPngExtension_whenGetSelectedPngFile_thenReturnFileWithPngExtension() {
        JFileChooser chooser = mock(JFileChooser.class);
        File testFile = new File(tempDir, "test");
        when(chooser.getSelectedFile()).thenReturn(testFile);
        File result = qrService.getSelectedFileForTests(chooser);
        assertTrue(result.getName().endsWith(".png"));
    }

    /** Vérifie qu'aucun conflit n'est détecté pour un nouveau fichier. */
    @Test
    @DisplayName("IO : Résolution de conflit pour un fichier inexistant")
    void givenNonExistingFile_whenResolveFileNameConflict_thenReturnSameFile() {
        File testFile = new File(tempDir, "nonexistent.png");
        try (var _ = mockStatic(MyPopup.class)) {
            File result = qrService.resolveFileNameConflictForTests(testFile);
            assertEquals(testFile, result);
        }
    }

    @Test
    @SuppressWarnings("MagicConstant")
    @DisplayName("IO : Retourne null après 1000 tentatives infructueuses")
    void givenOneThousandExistingFiles_whenResolveConflict_thenReturnNull() throws IOException {
        String baseName = "conflict";
        File baseFile = new File(tempDir, baseName + ".png");
        assertTrue(baseFile.createNewFile());
        for (int i = 1; i <= 1000; i++) {
            boolean _ = new File(tempDir, baseName + "(" + i + ").png").createNewFile();
        }
        try (MockedStatic<JOptionPane> mockedOptionPane = mockStatic(JOptionPane.class)) {
            mockedOptionPane
                    .when(
                            () ->
                                    JOptionPane.showConfirmDialog(
                                            any(),
                                            any(),
                                            anyString(),
                                            eq(JOptionPane.YES_NO_OPTION),
                                            eq(JOptionPane.WARNING_MESSAGE)))
                    .thenReturn(1);
            File result = qrService.resolveFileNameConflictForTests(baseFile);
            assertNull(
                    result, "Le service doit retourner null car la limite de 1000 est atteinte.");
            mockedOptionPane.verify(
                    () ->
                            JOptionPane.showMessageDialog(
                                    FrameHelper.INSTANCE.getParentFrame(),
                                    "Erreur de nommage Impossible de générer un nom unique après"
                                            + " 1000 essais.",
                                    "Erreur",
                                    JOptionPane.PLAIN_MESSAGE),
                    times(1));
        }
    }
}
