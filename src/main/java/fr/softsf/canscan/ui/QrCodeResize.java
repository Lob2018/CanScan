/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import fr.softsf.canscan.model.QrInput;
import fr.softsf.canscan.service.AbstractQrCodeWorker;

/**
 * Asynchronously resizes a generated QR code image for display in a Swing UI.
 *
 * <p>Resize operations are executed off the Event Dispatch Thread (EDT) to maintain UI
 * responsiveness. This class uses a debounce mechanism and background {@link SwingWorker} to avoid
 * unnecessary scaling when multiple layout or configuration changes occur rapidly.
 *
 * <p>Each instance manages resizing for a specific {@link JLabel}, working with a {@link
 * QrCodeBufferedImage} as the source image. The optional {@link Loader} can show a wait/progress
 * indicator while resizing is in progress.
 *
 * <p>Resources are properly managed: previous icons are disposed, background workers are cancelled,
 * and the loader is stopped to prevent memory leaks and ensure smooth UI updates.
 */
public class QrCodeResize extends AbstractQrCodeWorker<ImageIcon> {

    private static final int RESIZE_DEBOUNCE_DELAY_MS = 200;
    private static final int DEFAULT_SIZE = 50;

    private final QrCodeBufferedImage qrCodeBufferedImage;
    private final JLabel qrCodeLabel;

    /**
     * Constructs a new QR code resize manager for a specific label.
     *
     * @param qrCodeBufferedImage the source QR code image; must not be {@code null}
     * @param qrCodeLabel the label where the resized QR code will be displayed; must not be {@code
     *     null}
     * @param loader optional loader to show a wait/progress indicator; can be {@code null}
     */
    public QrCodeResize(
            QrCodeBufferedImage qrCodeBufferedImage, JLabel qrCodeLabel, Loader loader) {
        super(loader);
        this.qrCodeBufferedImage = qrCodeBufferedImage;
        this.qrCodeLabel = qrCodeLabel;
    }

    /**
     * Updates the current QR input and schedules a debounced resize operation.
     *
     * <p>Any ongoing resize worker is cancelled and a new one is started after a short delay.
     *
     * @param qrInput the latest QR code configuration
     */
    public void updateQrCodeResize(QrInput qrInput) {
        this.qrInput = qrInput;
        resetAndStartWorker(RESIZE_DEBOUNCE_DELAY_MS);
    }

    /**
     * Clears the current icon before starting a new resize task. Invoked automatically by the
     * {@link AbstractQrCodeWorker} workflow.
     */
    @Override
    protected void clearResources() {
        QrCodeIconUtil.INSTANCE.disposeIcon(qrCodeLabel);
        qrCodeLabel.setIcon(null);
    }

    /**
     * Creates a background {@link SwingWorker} that scales the QR code image to the target size.
     *
     * <p>Uses bilinear interpolation for smooth resizing. Cancels promptly if the thread is
     * interrupted.
     *
     * @return a configured {@link SwingWorker} that produces an {@link ImageIcon} for display
     */
    @Override
    protected SwingWorker<ImageIcon, Void> createWorker() {
        int size = Math.max(qrInput.availableHeightForQrCode(), DEFAULT_SIZE);
        return new SwingWorker<>() {
            @Override
            protected ImageIcon doInBackground() {
                BufferedImage src = qrCodeBufferedImage.getQrOriginal();
                if (src == null) {
                    return null;
                }
                BufferedImage scaled = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = scaled.createGraphics();
                try {
                    g.setRenderingHint(
                            RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.drawImage(src, 0, 0, size, size, null);
                } finally {
                    g.dispose();
                }
                return new ImageIcon(scaled);
            }

            @Override
            protected void done() {
                handleWorkerDone();
            }
        };
    }

    /**
     * Updates the label icon when the worker successfully completes.
     *
     * @param result the resized {@link ImageIcon}, or {@code null} if the task was cancelled
     */
    @Override
    protected void onWorkerSuccess(ImageIcon result) {
        if (result != null) {
            qrCodeLabel.setIcon(result);
        }
    }
}
