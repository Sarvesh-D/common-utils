package com.ds.utils;

import static com.ds.utils.StringUtils4.multiply;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringUtilsTest {

    @Test
    public final void stringATimesBTimesCShouldBeABC() {
        assertEquals("ABC", multiply("A", "B", "C"));
    }

    @Test
    public final void stringATimesEmptyTimesBShouldBeAB() {
        assertEquals("AB", multiply("A", EMPTY, "B"));
    }

    @Test
    public final void stringATimesNullTimesBShouldBeAB() {
        assertEquals("AB", multiply("A", null, "B"));
    }

    @Test
    public final void fiveTimesStringAShouldBeAAAAA() {
        assertEquals("AAAAA", multiply("A", 5));
    }

    @Test
    public final void fiveTimesStringNullShouldBeEmptyString() {
        assertEquals(EMPTY, multiply(null, 5));
    }

    @Test
    public final void fiveTimesStringEmptyShouldBeEmptyString() {
        assertEquals(EMPTY, multiply(EMPTY, 5));
    }

    @Test(expected = UnsupportedOperationException.class)
    public final void callingDifferenceShouldThrowUnsupportedOperationException() {
        StringUtils4.difference("AA", "BB");
    }

}
