/**
 *
 */
package com.ds.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 *
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class ObjectUtilsTest {

    @Test
    public void testInfo() {
        final String name = Random.indianName();
        assertEquals("String 'name' and it's object info should be same", name, ObjectUtils.info.apply(name));
        final String nullString = null;
        assertEquals("Null string should have object info as Empty String", StringUtils.EMPTY, ObjectUtils.info.apply(nullString));
    }

    @Test
    public void testArrayInfo() {
        final String[] randomNames = Stream.generate(() -> Random.indianName())
                                           .limit(10)
                                           .toArray(size -> new String[size]);
        assertNotNull("Info for String array should not be null", ObjectUtils.arrayInfo.apply(randomNames));
    }

}
