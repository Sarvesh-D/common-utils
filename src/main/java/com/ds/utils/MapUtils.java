/*******************************************************************************
 * Copyright 2018 Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.ds.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

/**
 * Utility class to deal with {@link Map}
 * 
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class MapUtils {

    private MapUtils() {
    }

    public static final String tabulate(final int colWidth, final Map<Object, Object> content) {
        return tabulate(colWidth, content, null);
    }

    public static final String tabulate(final int colWidth, final Map<Object, Object> content, final Entry<Object, Object> header) {
        return tabulate(colWidth, content, header, false, false, false);
    }

    public static final String tabulate(final int colWidth, final Map<Object, Object> content, final Entry<Object, Object> header, final boolean sorted, final boolean rowBorder,
            final boolean colBorder) {
        Assert.assertNotNull("Table content cannot be null", content);
        final StringJoiner rows = rowBorder ? new StringJoiner(StringUtils.join("\n", StringUtils4.multiply("-", 2 * colWidth), "\n")) : new StringJoiner("\n");
        checkAndAddHeader(colWidth, header, rows, colBorder);
        Map<Object, Object> tableContent = null;
        if (sorted) {
            tableContent = new TreeMap<>(content);
        } else {
            tableContent = content;
        }
        tableContent.entrySet()
                    .forEach(entry -> rows.add(row(colWidth, entry, colBorder)));
        return rows.toString();
    }

    private static String row(final int colWidth, final Entry<Object, Object> entry, final boolean colBorder) {
        return StringUtils.join(col(colWidth, entry.getKey(), colBorder), StringUtils4.SPACE, col(colWidth, entry.getValue(), colBorder));
    }

    private static String col(final int colWidth, final Object value, final boolean colBorder) {
        final String val = null != value ? value.toString() : StringUtils.EMPTY;
        if (colBorder) {
            return StringUtils.rightPad(val, colWidth);
        }
        return StringUtils.rightPad(val, colWidth);
    }

    private static void checkAndAddHeader(final int colWidth, final Entry<Object, Object> header, final StringJoiner rows, final boolean colBorder) {
        if (null != header) {
            rows.add(row(colWidth, header, colBorder));
        }
    }

}
