/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.model;

/**
 * Result container for version synchronization checks.
 *
 * @param statusCode HTTP response code from the GitHub API.
 * @param statusMessage Descriptive status of the operation result.
 * @param latestVersion Identified remote version tag, null if unreachable.
 * @param isUpToDate Equality status between local and remote versions.
 */
public record VersionValue(
        int statusCode, String statusMessage, String latestVersion, boolean isUpToDate) {}
