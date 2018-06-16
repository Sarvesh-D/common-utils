/**
 *
 */
package com.ds.utils;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Utility class to deal with {@link Object}
 *
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class ObjectUtils {

    private ObjectUtils() {
    }

    public static final Function<Object[], String> arrayInfo = Arrays::toString;

    public static final Function<Object, String> info = obj -> null != obj ? obj.toString() : StringUtils4.EMPTY;

}
