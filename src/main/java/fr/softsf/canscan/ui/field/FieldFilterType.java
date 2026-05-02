/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.ui.field;

/**
 * Defines the filtering strategies for text input fields.
 *
 * <p>These types determine how characters are sanitized and validated before being committed to the
 * document model.
 */
public enum FieldFilterType {
    /**
     * Strict filtering mode.
     *
     * <p>Prohibits semicolons (';') to maintain compatibility with MECARD/MEET delimited formats
     * and strips all line breaks (\n, \r).
     */
    STRICT,

    /**
     * Free-text filtering mode.
     *
     * <p>Allows all characters to maintain compatibility with the FREE delimited format and strips
     * all line breaks (\n, \r) to ensure single-line integrity.
     */
    FREE,

    /**
     * Numeric and coordinate filtering mode.
     *
     * <p>Restricts input to digits (0-9), decimal points (.), and minus signs (-). Also strips line
     * breaks (\n, \r) to prevent input corruption in geographic coordinates.
     */
    NUMERIC
}
