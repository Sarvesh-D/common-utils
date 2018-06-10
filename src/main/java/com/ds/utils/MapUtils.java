package com.ds.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

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
        return StringUtils.join(col(colWidth, entry.getKey(), colBorder), col(colWidth, entry.getValue(), colBorder));
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
