/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the MIT License (MIT).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.model;

import java.awt.Color;

/**
 * Input data structure for QR code generation and rendering.
 *
 * <p>Encapsulates user-provided content and visual configuration for generating a QR code. Supports
 * both MECARD (structured contact) and FREE (arbitrary text) modes.
 *
 * <p>This record is immutable and aggregates:
 *
 * <ul>
 *   <li>Contact details (MECARD mode)
 *   <li>Free-form text (FREE mode)
 *   <li>Visual customization (colors, logo, modules)
 *   <li>Size and layout options
 * </ul>
 *
 * @param availableHeightForQrCode vertical space available for rendering in the UI
 * @param currentMode encoding mode: {@link Mode#MECARD} or {@link Mode#FREE}
 * @param free free-form text content (used in FREE mode)
 * @param name contact full name (MECARD mode)
 * @param org organization or company (MECARD mode)
 * @param tel telephone number (MECARD mode)
 * @param email email address (MECARD mode)
 * @param adr postal address (MECARD mode)
 * @param url website or profile URL (MECARD mode)
 * @param logoPath optional logo file path to embed in the QR code
 * @param size target dimension (pixels) of the QR code image
 * @param margin quiet zone around the QR code (modules)
 * @param ratio logo visibility ratio (0.0–1.0)
 * @param qrColor color of QR code modules
 * @param bgColor background color
 * @param isRoundedModules whether modules are rendered with rounded corners
 */
public record WholeFields(
        int availableHeightForQrCode,
        Mode currentMode,
        String free,
        String name,
        String org,
        String tel,
        String email,
        String adr,
        String url,
        String logoPath,
        int size,
        int margin,
        double ratio,
        Color qrColor,
        Color bgColor,
        boolean isRoundedModules) {}
