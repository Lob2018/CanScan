/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import com.google.zxing.WriterException;

import fr.softsf.canscan.model.QrConfig;
import fr.softsf.canscan.model.QrDataResult;
import fr.softsf.canscan.ui.Popup;
import fr.softsf.canscan.ui.QrCodeBufferedImage;
import fr.softsf.canscan.util.Checker;
import fr.softsf.canscan.util.StringConstants;

/** Service dedicated to QR code generation and saving. */
@SuppressWarnings("ClassCanBeRecord")
public class GenerateAndSaveService {

    private final QrCodeBufferedImage qrCodeBufferedImage;

    /**
     * Constructs a GenerateAndSaveService with the given QR code image generator.
     *
     * @param qrCodeBufferedImage the QR code image generator; must not be null
     */
    public GenerateAndSaveService(QrCodeBufferedImage qrCodeBufferedImage) {
        this.qrCodeBufferedImage =
                Objects.requireNonNull(qrCodeBufferedImage, "qrCodeBufferedImage must not be null");
    }

    /**
     * Generates and saves a QR code as a PNG file using the provided data and configuration.
     *
     * <p>Validates the input data, applies visual settings (colors, margin, logo, module style),
     * generates the QR code image, and opens a file chooser to save the file. Handles file name
     * conflicts and shows user feedback dialogs for success, errors, or exceptions.
     *
     * @param qrData the QR code data; must not be null
     * @param config the QR code visual configuration; must not be null
     */
    public void generateAndSave(QrDataResult qrData, QrConfig config) {
        if (Checker.INSTANCE.checkNPE(
                        qrData,
                        StringConstants.GENERATE_AND_SAVE_QR_CODE.getValue(),
                        StringConstants.QR_DATA.getValue())
                || Checker.INSTANCE.checkNPE(
                        config, StringConstants.GENERATE_AND_SAVE_QR_CODE.getValue(), "config")) {
            return;
        }
        if (qrData.data().isBlank()) {
            Popup.INSTANCE.showDialog("", "Aucune donnée à encoder", "Information");
            return;
        }
        try {
            BufferedImage qr = qrCodeBufferedImage.generateQrCodeImage(qrData.data(), config);
            qrCodeBufferedImage.updateQrOriginal(qr);
            File outputFile = chooseOutputFile(qrData);
            if (outputFile == null) {
                return;
            }
            try (OutputStream os = new FileOutputStream(outputFile)) {
                ImageIO.write(qr, "png", os);
            }
            Popup.INSTANCE.showDialog(
                    "Code QR enregistré dans\n", outputFile.getAbsolutePath(), "Confirmation");
        } catch (WriterException we) {
            Popup.INSTANCE.showDialog(
                    "Pas de génération du QR Code\n",
                    we.getMessage(),
                    StringConstants.ERREUR.getValue());
        } catch (IOException ioe) {
            Popup.INSTANCE.showDialog(
                    "Pas de lecture/écriture de fichier\n",
                    ioe.getMessage(),
                    StringConstants.ERREUR.getValue());
        } catch (OutOfMemoryError oom) {
            Popup.INSTANCE.showDialog(
                    "Manque de mémoire\n", oom.getMessage(), StringConstants.ERREUR.getValue());
        }
    }

    /**
     * Opens a JFileChooser to select the output PNG file and handles file name conflicts.
     *
     * @param qrData the QR code data used to generate the default file name
     * @return the selected file ready for writing, or null if the user cancels
     */
    private File chooseOutputFile(QrDataResult qrData) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Enregistrer votre code QR en tant que PNG");
        chooser.setSelectedFile(new File(qrData.defaultFileName()));
        chooser.setFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter("PNG Images", "png"));
        if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return resolveFileNameConflict(getSelectedPngFile(chooser));
    }

    /**
     * Ensures the selected file has a ".png" extension.
     *
     * @param chooser the file chooser
     * @return a File guaranteed to have a ".png" extension
     */
    private File getSelectedPngFile(JFileChooser chooser) {
        if (Checker.INSTANCE.checkNPE(chooser, "getSelectedPngFile", "chooser")) {
            return null;
        }
        File output = chooser.getSelectedFile();
        String fileName = output.getName().toLowerCase();
        if (fileName.endsWith(".png")) {
            return output;
        }
        return new File(output.getParentFile(), output.getName() + ".png");
    }

    /**
     * Resolves potential file name conflicts by checking if the specified file already exists.
     *
     * <p>If the file exists, the user is prompted to overwrite it. If the user declines, a new file
     * name is generated by appending a numeric suffix to avoid overwriting existing files.
     *
     * @param file the initial File to check for conflicts
     * @return a File ready for writing, either the original, user-approved, or auto-renamed, or
     *     null if input file is null
     */
    private File resolveFileNameConflict(File file) {
        if (Checker.INSTANCE.checkNPE(file, "resolveFileNameConflict", "file")) {
            return null;
        }
        if (file.exists()) {
            int choice =
                    Popup.INSTANCE.showYesNoConfirmDialog(
                            null,
                            "Un fichier \""
                                    + file.getName()
                                    + "\" existe déjà.\nÉcraser ce fichier ?");
            if (choice == 0) {
                return file;
            }
            String baseName = file.getName().replaceFirst("\\.png$", "");
            File parent = file.getParentFile();
            int counter = 1;
            File candidate;
            do {
                candidate = new File(parent, baseName + "(" + counter + ").png");
                counter++;
            } while (candidate.exists());
            return candidate;
        }
        return file;
    }
}
