/**
 *
 */
package com.ds.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
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
public class CollectionUtilsTest {

    private List<String> randomNames;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        randomNames = Stream.generate(() -> Random.indianName())
                            .limit(10)
                            .collect(Collectors.toList());
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        randomNames.clear();
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#randomElem(java.util.List)}.
     */
    @Test
    public void testRandomElem() {
        final String name = CollectionUtils.randomElem(randomNames);
        assertNotNull("Random Name found as null", name);
        assertTrue("Random name found does not belong to source collection", randomNames.contains(name));
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#randomElems(java.util.List, int)}.
     */
    @Test
    public void testRandomElems() {
        final List<String> randomNamesPicked = CollectionUtils.randomElems(randomNames, 5);
        assertNotNull("Random Names picked found as null", randomNamesPicked);
        assertTrue("5 random names should be picked", randomNamesPicked.size() == 5);
        randomNamesPicked.forEach(name -> assertTrue("Random name found does not belong to source collection", randomNames.contains(name)));
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#removeRandomElem(java.util.List)}.
     */
    @Test
    public void testRemoveRandomElem() {
        final int actualSize = randomNames.size();
        CollectionUtils.removeRandomElem(randomNames);
        assertTrue("Exactly one random element should have been removed", actualSize - randomNames.size() == 1);
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#removeRandomElems(java.util.List, int)}.
     */
    @Test
    public void testRemoveRandomElems() {
        final int actualSize = randomNames.size();
        CollectionUtils.removeRandomElems(randomNames, 3);
        assertTrue("Exactly three random element should have been removed", actualSize - randomNames.size() == 3);
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#getElems(java.util.List, java.lang.Object)}.
     */
    @Test
    public void testGetElems() {
        final String name = CollectionUtils.randomElem(randomNames);
        final Optional<String> fetchedName = CollectionUtils.getElem(randomNames, name);
        assertTrue("Fetched name should not be present", fetchedName.isPresent());
    }

    /**
     * Test method for
     * {@link com.ds.utils.CollectionUtils#getElem(java.util.List, java.lang.Object)}.
     */
    @Test
    public void testGetElem() {
        final List<String> names = CollectionUtils.getElems(randomNames, CollectionUtils.randomElem(randomNames));
        assertNotNull("Fetched names cannot be null", names);
        assertTrue("Fetched names must contain atleast one name", names.size() >= 1);
    }

}
