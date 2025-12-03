/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.model;

import java.awt.Color;
import java.util.function.IntSupplier;

/**
 * Immutable data structure (record) for QR code generation input.
 *
 * <p>This record encapsulates all user-provided data (text content, coordinates) and visual
 * configuration (colors, dimensions, logo) required to create and render a QR code.
 *
 * <p>It supports different encoding modes (defined by {@link Mode}):
 *
 * <ul>
 *   <li>{@link Mode#MECARD}: Structured business/contact cards.
 *   <li>{@link Mode#MEET}: Event or meeting invitations (calendar data).
 *   <li>{@link Mode#FREE}: Simple free-form text or URL.
 * </ul>
 *
 * @param availableHeightForQrCode An {@link IntSupplier} that provides the available vertical
 *     height in pixels for QR code rendering upon invocation (lazy evaluation).
 * @param currentMode The active encoding mode for the QR code content.
 *     <h3>MECARD Mode Parameters</h3>
 *
 * @param name Full name of the contact.
 * @param org Organization or company name.
 * @param tel Telephone number.
 * @param email Email address.
 * @param adr Postal address.
 * @param url Website or profile URL.
 *     <h3>MEETING Mode Parameters</h3>
 *
 * @param meetTitle Title of the meeting or event.
 * @param meetUId Unique event identifier (UID).
 * @param meetName Organizer or event name.
 * @param meetBeginDateTime Event start date and time in UTC format (e.g., 19970715T040000Z).
 * @param meetEndDateTime Event end date and time in UTC format (e.g., 19970715T040000Z).
 * @param meetLat Geographic latitude of the meeting location.
 * @param meetLong Geographic longitude of the meeting location.
 *     <h3>FREE Mode Parameter</h3>
 *
 * @param free Free-form text content (unstructured text or simple URL).
 *     <h3>General and Visual Configuration</h3>
 *
 * @param logoPath Optional file path for the image to embed in the center of the QR code.
 * @param size Target image size of the QR code in pixels (including the quiet zone).
 * @param margin Quiet zone size in modules.
 * @param ratio Logo visibility ratio (maximum logo radius / QR code size), between 0.0 and 1.0.
 * @param qrColor Color of the QR code modules.
 * @param bgColor Background color of the QR code and the quiet zone.
 * @param isRoundedModules {@code true} if modules should be rendered with rounded corners.
 */
public record WholeFields(
        IntSupplier availableHeightForQrCode,
        Mode currentMode,
        String free,
        String name,
        String org,
        String tel,
        String email,
        String adr,
        String url,
        String meetTitle,
        String meetUId,
        String meetName,
        String meetBeginDateTime,
        String meetEndDateTime,
        String meetLat,
        String meetLong,
        String logoPath,
        int size,
        int margin,
        double ratio,
        Color qrColor,
        Color bgColor,
        boolean isRoundedModules) {}
