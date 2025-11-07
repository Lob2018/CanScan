/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.model;

import java.awt.Color;
import java.io.File;

/** Configuration parameters used to generate a QR code. */
public record QrConfig(
        File logoFile,
        int size,
        double imageRatio,
        Color qrColor,
        Color bgColor,
        boolean roundedModules,
        int margin) {}
