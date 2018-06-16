/**
 *
 */
package com.ds.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class MapUtilsTest {

    private static Logger log = Logger.getAnonymousLogger();

    private Map<Object, Object> randomPeople;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        randomPeople = Stream.generate(() -> new AbstractMap.SimpleEntry<>(Random.indianName(), Random.age(14, 45)))
                             .limit(10)
                             .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        randomPeople.clear();
    }

    /**
     * Test method for {@link com.ds.utils.MapUtils#tabulate(int, java.util.Map)}.
     */
    @Test
    public void testBasicMapTabulation() {
        final String tabulatedString = MapUtils.tabulate(20, randomPeople);
        log.info(tabulatedString);
        assertNotNull("Tabulated String cannot be null", tabulatedString);
        final int rows = tabulatedString.split("\n").length;
        assertEquals("Number of rows must be equal to number of entries in map", randomPeople.size(), rows);
    }

    /**
     * Test method for
     * {@link com.ds.utils.MapUtils#tabulate(int, java.util.Map, java.util.Map.Entry)}.
     */
    @Test
    public void testMapTabulationWithCustomHeader() {
        final String tabulatedString = MapUtils.tabulate(20, randomPeople, new AbstractMap.SimpleEntry<>("Name", "Age"));
        log.info(tabulatedString);
        assertNotNull("Tabulated String cannot be null", tabulatedString);
        final int rows = tabulatedString.split("\n").length;
        assertTrue("Number of rows must be one greater than number of entries in map", rows - randomPeople.size() == 1);
    }

}
