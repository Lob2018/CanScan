/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import fr.softsf.canscan.util.Checker;
import fr.softsf.canscan.util.FontManager;
import fr.softsf.canscan.util.FrameHelper;

/**
 * Utility class for managing QR code colors and color-related UI operations.
 *
 * <p>Handles color selection dialogs, button icon generation, and color-to-hex conversions for the
 * QR code generator interface.
 */
public class ColorOperation {

    private static final int BUTTON_COLOR_ICON_TEXT_GAP = 10;
    private static final float STROKE_WIDTH = 2f;
    private static final String BORDER_COLOR = "#003f5e";
    private static final String DEFAULT_HEX_COLOR = "#FFFFFF";
    private static final String CHOOSE_COLOR = "chooseColor";
    private static final String BUTTON = "button";
    private static final String COLOR = "color";

    /**
     * Opens a color chooser dialog and updates the button with the selected color.
     *
     * @param button the button to update with the new color
     * @param currentColor the current color to display initially
     * @param isQrColor true if this is for QR modules, false for background
     * @return the selected color, or null if cancelled
     */
    public Color chooseColor(JButton button, Color currentColor, boolean isQrColor) {
        if (Checker.INSTANCE.checkNPE(button, CHOOSE_COLOR, BUTTON)
                || Checker.INSTANCE.checkNPE(currentColor, CHOOSE_COLOR, "currentColor")) {
            return null;
        }
        String title = isQrColor ? "Choisir la couleur des modules" : "Choisir la couleur du fond";
        Color chosen =
                JColorChooser.showDialog(
                        FrameHelper.INSTANCE.getParentFrame(), title, currentColor);
        if (chosen != null) {
            updateButtonWithColor(button, chosen);
        }
        return chosen;
    }

    /**
     * Updates a button's icon and text to reflect a new color.
     *
     * @param button the button to update
     * @param color the color to display
     */
    public void updateButtonWithColor(JButton button, Color color) {
        if (Checker.INSTANCE.checkNPE(button, "updateButtonWithColor", BUTTON)
                || Checker.INSTANCE.checkNPE(color, "updateButtonWithColor", COLOR)) {
            return;
        }
        button.setIcon(createColorIcon(button, color));
        button.setText(colorToHex(color));
    }

    /**
     * Initializes a color button with icon, text, and tooltip.
     *
     * @param button the button to initialize
     * @param color the initial color
     * @param isQrColor true if this is for QR modules, false for background
     */
    public void initializeColorButton(JButton button, Color color, boolean isQrColor) {
        if (Checker.INSTANCE.checkNPE(button, "initializeColorButton", BUTTON)
                || Checker.INSTANCE.checkNPE(color, "initializeColorButton", COLOR)) {
            return;
        }
        button.setIconTextGap(BUTTON_COLOR_ICON_TEXT_GAP);
        updateButtonWithColor(button, color);
        String tooltip = isQrColor ? "Couleur des modules." : "Couleur du fond.";
        button.setToolTipText(tooltip);
    }

    /**
     * Creates a square icon filled with the specified color and a visible border.
     *
     * <p>The icon size is dynamically optimized using the FontManager's reference width.
     *
     * @param button the button whose previous icon will be disposed
     * @param color the color to display in the icon
     * @return an ImageIcon displaying the color with a border, or null if inputs are null
     */
    private Icon createColorIcon(JButton button, Color color) {
        if (Checker.INSTANCE.checkNPE(button, "createColorIcon", BUTTON)
                || Checker.INSTANCE.checkNPE(color, "createColorIcon", COLOR)) {
            return null;
        }
        disposeButtonIcon(button);
        final int size = FontManager.INSTANCE.getCharWidth();
        final float stroke = STROKE_WIDTH;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        try {
            g2.setRenderingHint(
                    java.awt.RenderingHints.KEY_ANTIALIASING,
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRect(0, 0, size, size);
            g2.setColor(Color.decode(BORDER_COLOR));
            g2.setStroke(new BasicStroke(stroke));
            g2.draw(
                    new java.awt.geom.Rectangle2D.Float(
                            stroke / 2f, stroke / 2f, size - stroke, size - stroke));
        } finally {
            g2.dispose();
        }
        return new ImageIcon(image);
    }

    /**
     * Disposes the current icon of a button to free memory.
     *
     * @param button the button whose icon should be disposed
     */
    private void disposeButtonIcon(JButton button) {
        if (button == null) {
            return;
        }
        ImageIcon oldIcon = (ImageIcon) button.getIcon();
        if (oldIcon != null) {
            Image oldImage = oldIcon.getImage();
            if (oldImage != null) {
                oldImage.flush();
            }
            button.setIcon(null);
        }
    }

    /**
     * Converts a Color object to its hexadecimal RGB string representation.
     *
     * @param color the Color to convert
     * @return a hexadecimal string in the format "#RRGGBB", e.g., "#FF00AA"
     */
    public String colorToHex(Color color) {
        if (Checker.INSTANCE.checkNPE(color, "colorToHex", COLOR)) {
            return DEFAULT_HEX_COLOR;
        }
        return String.format(Locale.ROOT, "#%06X", color.getRGB() & 0x00FFFFFF);
    }
}
