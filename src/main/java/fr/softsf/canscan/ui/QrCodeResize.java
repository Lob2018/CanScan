/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import org.apache.commons.lang3.StringUtils;

import fr.softsf.canscan.model.QrDataResult;
import fr.softsf.canscan.model.QrInput;
import fr.softsf.canscan.service.BuildQRDataService;
import fr.softsf.canscan.util.Checker;

/**
 * Singleton responsible for managing asynchronous resizing of generated QR code images.
 *
 * <p>Runs resizing operations off the Event Dispatch Thread (EDT) to maintain UI responsiveness.
 * Debouncing, worker cancellation, and resource cleanup are handled automatically. Ensures
 * flicker-free updates when the UI or QR configuration changes.
 */
public enum QrCodeResize {
    INSTANCE;

    private static final int DEFAULT_GAP = 15;
    private static final int QR_CODE_LABEL_DEFAULT_SIZE = 50;
    private static final int LARGE_IMAGE_THRESHOLD = 1000;
    private static final int RESIZE_DEBOUNCE_DELAY_MS = 200;
    private static final String QR_DATA = "qrData";
    private static final String ERREUR = "Erreur";
    private transient Timer resizeDebounceTimer;
    private transient SwingWorker<ImageIcon, Void> resizeWorker;
    private transient JLabel qrCodeLabel;
    private QrInput qrInput;

    /**
     * Initializes this instance with the target {@link JLabel} where the resized QR code will be
     * displayed.
     *
     * @param qrCodeLabel the label used for rendering the resized image
     */
    public void init(JLabel qrCodeLabel) {
        this.qrCodeLabel = qrCodeLabel;
    }

    /**
     * Returns the current debounce timer.
     *
     * @return the active {@link Timer}, or {@code null} if none
     */
    public Timer getResizeDebounceTimer() {
        return resizeDebounceTimer;
    }

    /**
     * Updates the debounce timer with a new instance.
     *
     * @param resizeDebounceTimer the timer to assign
     */
    public void updateResizeDebounceTimer(Timer resizeDebounceTimer) {
        this.resizeDebounceTimer = resizeDebounceTimer;
    }

    /** Stops the current debounce timer and clears its reference. */
    public void stop() {
        if (resizeDebounceTimer != null) {
            resizeDebounceTimer.stop();
            resizeDebounceTimer = null;
        }
    }

    /**
     * Checks if a resize debounce timer is currently running.
     *
     * @return {@code true} if active, otherwise {@code false}
     */
    public boolean isRunning() {
        return resizeDebounceTimer != null && resizeDebounceTimer.isRunning();
    }

    /**
     * Launches a background worker that resizes the QR code image to the specified height.
     *
     * @param height the desired image height in pixels
     */
    public void launchResizeWorker(int height) {
        resizeWorker = createResizeWorker(height);
        resizeWorker.execute();
    }

    /**
     * Creates a {@link SwingWorker} to perform image resizing off the EDT and update the UI when
     * the task completes successfully. Ensures the wait icon is stopped in all cases.
     *
     * @param height the target height for resizing
     * @return a new SwingWorker instance configured for resizing
     */
    private SwingWorker<ImageIcon, Void> createResizeWorker(int height) {
        return new SwingWorker<>() {
            @Override
            protected ImageIcon doInBackground() {
                Thread.currentThread().setName("ResizeWorker");
                return resizeImageInBackground(height);
            }

            @Override
            protected void done() {
                Loader.INSTANCE.stopWaitIcon();
                handleResizeWorkerCompletion(this);
            }
        };
    }

    /**
     * Performs image resizing logic off the EDT. Uses interpolation based on target size for
     * optimal quality and speed. Cancels promptly if the thread is interrupted.
     *
     * @param squareSize the target height for the resized QR code
     * @return an {@link ImageIcon} containing the resized image, or {@code null} if cancelled or
     *     invalid
     */
    private ImageIcon resizeImageInBackground(int squareSize) {
        if (squareSize <= 0
                || QrCodeBufferedImage.INSTANCE.getQrOriginal() == null
                || Thread.currentThread().isInterrupted()) {
            return null;
        }
        BufferedImage scaled =
                new BufferedImage(squareSize, squareSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        try {
            g2d.setRenderingHint(
                    RenderingHints.KEY_INTERPOLATION,
                    squareSize > LARGE_IMAGE_THRESHOLD
                            ? RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
                            : RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(
                    QrCodeBufferedImage.INSTANCE.getQrOriginal(),
                    0,
                    0,
                    squareSize,
                    squareSize,
                    null);
        } finally {
            g2d.dispose();
        }
        if (Thread.currentThread().isInterrupted()) {
            scaled.flush();
            return null;
        }
        return new ImageIcon(scaled);
    }

    /**
     * Handles resize worker completion, ensuring that cancellation and stale worker checks are
     * performed before updating the UI.
     *
     * <p>Flushes obsolete icons and reports any errors encountered during execution.
     *
     * @param worker the completed SwingWorker instance
     */
    private void handleResizeWorkerCompletion(SwingWorker<ImageIcon, Void> worker) {
        if (Checker.INSTANCE.checkNPE(worker, "handleResizeWorkerCompletion", "worker")) {
            return;
        }
        boolean cancelledOrStale = worker.isCancelled() || worker != resizeWorker;
        try {
            ImageIcon icon = worker.get();
            if (cancelledOrStale) {
                if (icon != null) {
                    icon.getImage().flush();
                }
                return;
            }
            if (icon != null) {
                QrCodeIconUtil.INSTANCE.disposeIcon(qrCodeLabel);
                qrCodeLabel.setIcon(icon);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (CancellationException | ExecutionException ex) {
            if (cancelledOrStale) {
                return;
            }
            Popup.INSTANCE.showDialog("Pas de redimensionnement\n", ex.getMessage(), ERREUR);
        }
    }

    /**
     * Cancels any active resize worker and waits for proper termination. Prevents multiple
     * concurrent resize operations.
     */
    public void cancelPreviousResizeWorker() {
        if (resizeWorker == null || resizeWorker.isDone()) {
            return;
        }
        resizeWorker.cancel(true);
        try {
            resizeWorker.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException | CancellationException ignored) {
            // Expected: CancellationException if cancelled, ExecutionException if task failed
        }
        resizeWorker = null;
        Loader.INSTANCE.stopWaitIcon();
    }

    /**
     * Updates internal {@link QrInput} and schedules a debounced QR code resize. Cancels any active
     * resize and triggers a new one after a short delay.
     *
     * @param qrInput latest QR code configuration
     */
    public void updateQrCodeSize(QrInput qrInput) {
        this.qrInput = qrInput;
        if (QrCodeResize.INSTANCE.isRunning()) {
            QrCodeResize.INSTANCE.getResizeDebounceTimer().restart();
            return;
        }
        QrCodeResize.INSTANCE.updateResizeDebounceTimer(
                new Timer(RESIZE_DEBOUNCE_DELAY_MS, e -> handleResize()));
        QrCodeResize.INSTANCE.getResizeDebounceTimer().setRepeats(false);
        QrCodeResize.INSTANCE.getResizeDebounceTimer().start();
    }

    /**
     * Handles the QR code resize process after the debounce delay. Validates input, available
     * space, and launches a new resize task.
     */
    private void handleResize() {
        int squareSize = qrInput.availableHeightForQrCode() - DEFAULT_GAP * 3;
        if (squareSize < QR_CODE_LABEL_DEFAULT_SIZE) {
            squareSize = QR_CODE_LABEL_DEFAULT_SIZE;
        }
        qrCodeLabel.setPreferredSize(new Dimension(squareSize, squareSize));
        QrDataResult qrData =
                BuildQRDataService.INSTANCE.buildQrData(qrInput.currentMode(), qrInput);
        if (isInvalidQrData(qrData)) {
            return;
        }
        if (QrCodeBufferedImage.INSTANCE.getQrOriginal() == null) {
            return;
        }
        resetAndStartResizeWorker(squareSize);
    }

    /**
     * Checks whether {@link QrDataResult} is invalid or null, and performs cleanup if necessary.
     *
     * @param qrData the QR data to validate
     * @return true if invalid, false otherwise
     */
    private boolean isInvalidQrData(QrDataResult qrData) {
        if (Checker.INSTANCE.checkNPE(qrData, "isInvalidQrData", QR_DATA)
                || StringUtils.isBlank(qrData.data())) {
            Loader.INSTANCE.stopWaitIcon();
            QrCodeBufferedImage.INSTANCE.freeQrOriginal();
            QrCodeIconUtil.INSTANCE.disposeIcon(qrCodeLabel);
            return true;
        }
        return false;
    }

    /**
     * Cancels any pending task, clears the current icon, starts the wait animation, and launches a
     * new resize worker for the given height.
     *
     * @param height target height for the resized image
     * @see #resetAndStartResizeWorker(int)
     */
    private void resetAndStartResizeWorker(int height) {
        QrCodeResize.INSTANCE.cancelPreviousResizeWorker();
        QrCodeIconUtil.INSTANCE.disposeIcon(qrCodeLabel);
        qrCodeLabel.setIcon(null);
        SwingUtilities.invokeLater(Loader.INSTANCE::startAndAdjustWaitIcon);
        QrCodeResize.INSTANCE.launchResizeWorker(height);
    }
}
