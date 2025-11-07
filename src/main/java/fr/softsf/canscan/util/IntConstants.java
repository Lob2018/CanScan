/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.util;

/** Integer constants for dimensions and spacing. */
public enum IntConstants {
    DEFAULT_GAP(15);

    private final int value;

    IntConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
