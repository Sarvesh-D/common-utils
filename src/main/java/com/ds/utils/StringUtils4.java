package com.ds.utils;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StringUtils4 extends org.apache.commons.lang3.StringUtils {

    private StringUtils4() {
    }

    /**
     * Adds and returns new String containing supplied strings.<br>
     * <ul>
     * <li>multiply("A", "B", "C") = "ABC"</li>
     * <li>multiply("A", " ", "C") = "A C"</li>
     * <li>multiply("A", "", "C") = "AC"</li>
     * <li>multiply("A", null, "C") = "AC"</li>
     * </ul>
     *
     * @param strings
     * @return
     */
    public static final String multiply(final CharSequence... strings) {
        final StringJoiner result = new StringJoiner(EMPTY);
        Stream.of(strings)
              .filter(StringUtils::isNotEmpty)
              .forEach(result::add);
        return result.toString();
    }

    public static final String multiply(final String string, final int times) {
        final StringJoiner result = new StringJoiner(EMPTY);
        IntStream.range(0, times)
                 .forEach(i -> result.add(multiply(string)));
        return result.toString();
    }

    /**
     * Finds the difference between given strings. Difference here means the set
     * containing characters which are not present in both the strings.
     * Mathematically, its equivalent to (A intersection B)'. This method ignores
     * the case.
     *
     * @param s1
     * @param s2
     * @return String containing characters which are not common to s1 and s2
     */
    public static final String difference(final String s1, final String s2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
