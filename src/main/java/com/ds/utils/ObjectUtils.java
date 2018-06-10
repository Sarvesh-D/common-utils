/**
 *
 */
package com.ds.utils;

import java.util.Arrays;
import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Sarvesh
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectUtils {

    public static final Function<Object[], String> arrayInfo = Arrays::toString;

    public static final Function<Object, String> info = obj -> null != obj ? obj.toString() : StringUtils4.EMPTY;

}
