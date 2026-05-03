/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui.field;

import javax.swing.text.JTextComponent;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import fr.softsf.canscan.util.Checker;

/**
 * Configuration data for a validated UI text field.
 *
 * <p>This record encapsulates the component, its filtering strategy, length constraints, and the
 * action to trigger upon document changes.
 *
 * @param field The {@link JTextComponent} component to be configured.
 * @param fieldFilterType The {@link FieldFilterType} determining the sanitization strategy.
 * @param maxLength The maximum number of characters allowed for this field.
 * @param action The {@link Runnable} callback to execute when the content changes.
 */
public record FieldConfig(
        JTextComponent field, FieldFilterType fieldFilterType, int maxLength, Runnable action) {

    private static final String FIELD_CONFIG = "FieldConfig";

    /**
     * @return New instance or null if any parameter is null.
     */
    public static FieldConfig of(JTextComponent f, FieldFilterType ft, int m, Runnable a) {
        return (Checker.INSTANCE.checkNPE(f, FIELD_CONFIG, "field")
                        || Checker.INSTANCE.checkNPE(ft, FIELD_CONFIG, "fieldFilterType")
                        || Checker.INSTANCE.checkNPE(a, FIELD_CONFIG, "action"))
                ? null
                : new FieldConfig(f, ft, m, a);
    }

    /**
     * Compact constructor for {@link FieldConfig}.
     *
     * <p>Applies SpotBugs suppression for Swing component exposure.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Swing intentional")
    public FieldConfig {
        // Compact constructor to apply SpotBugs suppression on auto-generated assignments.
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Swing intentional")
    public JTextComponent field() {
        return field;
    }
}
