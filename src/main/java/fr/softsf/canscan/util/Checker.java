/*
 * CanScan - Copyright © 2025-present SOFT64.FR Lob2018
 * Licensed under the GNU General Public License v3.0 (GPLv3.0).
 * See the full license at: https://github.com/Lob2018/CanScan?tab=License-1-ov-file#readme
 */
package fr.softsf.canscan.util;

import org.apache.commons.lang3.StringUtils;

import fr.softsf.canscan.ui.MyPopup;

/**
 * Centralized argument validation utility for detecting and reporting {@code null} or blank values.
 *
 * <p>Implemented as an enum singleton to ensure a single shared instance. Designed for defensive
 * programming and consistent user feedback through standardized error dialogs.
 */
public enum Checker {
    INSTANCE;

    /**
     * Performs a non-blocking null or blank check and triggers a diagnostic dialog upon failure. *
     *
     * <p><b>Note:</b> This method does not throw exceptions. Callers must handle the boolean return
     * value to ensure thread safety and prevent downstream {@link NullPointerException}. *
     *
     * <p><b>Execution Patterns:</b>
     *
     * <ul>
     *   <li>Standard guard clause: {@code if (Checker.INSTANCE.checkNPE(arg, "method", "arg"))
     *       return;}
     *   <li>Constructor validation: {@code Checker.INSTANCE.checkNPE(arg, ...); this.field =
     *       Objects.requireNonNull(arg);}
     * </ul>
     *
     * @param obj the object to validate; performs blank check if instance of {@link String}
     * @param methodName diagnostic context identifying the caller
     * @param name display name of the validated parameter
     * @return {@code true} if the object is {@code null} or blank; {@code false} otherwise
     */
    public boolean checkNPE(Object obj, String methodName, String name) {
        return checkNullOrBlankInternal(obj, methodName, name);
    }

    /**
     * Validates the given object for {@code null} or blank values. Displays a standardized error
     * dialog if invalid.
     *
     * @param obj the object to validate
     * @param methodName the name of the calling method
     * @param name the name of the parameter
     * @return {@code true} if the object is invalid; {@code false} otherwise
     */
    private boolean checkNullOrBlankInternal(Object obj, String methodName, String name) {
        String errorType = null;
        if (obj == null) {
            errorType = "null";
        } else if (obj instanceof String s && StringUtils.isBlank(s)) {
            errorType = "blank";
        }
        if (errorType == null) {
            return false;
        }
        MyPopup.INSTANCE.showArgumentErrorDialog(
                FrameHelper.INSTANCE.getParentFrame(), methodName, name, errorType);
        return true;
    }
}
