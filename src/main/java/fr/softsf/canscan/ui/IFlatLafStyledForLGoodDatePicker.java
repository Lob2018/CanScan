/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Interface providing FlatLaf styling support for LGoodDatePicker components.
 *
 * <p>Supplies a default text field height, applies FlatLaf theme to the internal text field, and
 * optionally installs a listener to reapply styling when LookAndFeel defaults change.
 */
public interface IFlatLafStyledForLGoodDatePicker {

    int TEXT_FIELD_HEIGHT = new JTextField().getPreferredSize().height;

    /**
     * Returns the internal JTextField used by the LGoodDatePicker.
     *
     * @return the component's internal JTextField
     */
    JTextField getInternalTextField();

    /**
     * Adjusts the given dimension to use the standard text field height.
     *
     * @param original the original dimension
     * @return the dimension with height set to TEXT_FIELD_HEIGHT
     */
    default Dimension computePreferredSize(Dimension original) {
        original.height = TEXT_FIELD_HEIGHT;
        return original;
    }

    /**
     * Applies FlatLaf styling to the internal JTextField. Sets border, colors, font, and margins
     * according to UIManager defaults.
     */
    default void applyTheme() {
        JTextField textField = getInternalTextField();
        if (textField != null) {
            textField.setBorder(UIManager.getBorder("TextField.border"));
            textField.setBackground(UIManager.getColor("TextField.background"));
            textField.setForeground(UIManager.getColor("TextField.foreground"));
            textField.setCaretColor(UIManager.getColor("TextField.caretForeground"));
            textField.setSelectionColor(UIManager.getColor("TextField.selectionBackground"));
            textField.setSelectedTextColor(UIManager.getColor("TextField.selectionForeground"));
            textField.setDisabledTextColor(UIManager.getColor("TextField.inactiveForeground"));
            textField.setFont(UIManager.getFont("TextField.font"));
            Insets margin = UIManager.getInsets("TextField.margin");
            if (margin != null) {
                textField.setMargin(margin);
            }
            textField.revalidate();
            textField.repaint();
        }
    }

    /**
     * Installs a property change listener on the internal text field. Automatically reapplies the
     * FlatLaf theme when font, background, or foreground changes.
     */
    default void installThemeListener() {
        JTextField textField = getInternalTextField();
        if (textField != null) {
            textField.addPropertyChangeListener(
                    evt -> {
                        if ("font".equals(evt.getPropertyName())
                                || "background".equals(evt.getPropertyName())
                                || "foreground".equals(evt.getPropertyName())) {
                            applyTheme();
                        }
                    });
        }
    }
}
