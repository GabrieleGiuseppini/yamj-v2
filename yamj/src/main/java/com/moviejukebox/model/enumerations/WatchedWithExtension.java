/*
 *      Copyright (c) 2004-2016 YAMJ Members
 *      https://github.com/orgs/YAMJ/people
 *
 *      This file is part of the Yet Another Movie Jukebox (YAMJ) project.
 *
 *      YAMJ is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      YAMJ is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with YAMJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 *      Web: https://github.com/YAMJ/yamj-v2
 *
 */
package com.moviejukebox.model.enumerations;

import java.util.EnumSet;
import org.apache.commons.lang3.StringUtils;

/**
 * Check the watched file with the extension of the video, without or both
 *
 * @author Stuart
 */
public enum WatchedWithExtension {

    EXTENSION("true"),
    NOEXTENSION("false"),
    BOTH("both");
    private final String type;

    private WatchedWithExtension(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    /**
     * Convert a string into an Enum type
     *
     * @param extensionString
     * @return
     */
    public static WatchedWithExtension fromString(String extensionString) {
        if (StringUtils.isNotBlank(extensionString)) {
            for (final WatchedWithExtension extension : EnumSet.allOf(WatchedWithExtension.class)) {
                if (extensionString.equalsIgnoreCase(extension.type)) {
                    return extension;
                }
            }
        }
        // We've not found the type, so return both
        return BOTH;
    }
}
