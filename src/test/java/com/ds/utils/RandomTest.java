/**
 *
 */
package com.ds.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 *
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class RandomTest {

    @Test
    public void testSuppliers() {
        assertTrue("First Name supplier cannot return null or blank firstName", StringUtils.isNotBlank(Random.firstName.get()));
        assertTrue("Last Name supplier cannot return null or blank lastName", StringUtils.isNotBlank(Random.lastName.get()));
        assertTrue("City supplier cannot return null or blank city", StringUtils.isNotBlank(Random.city.get()));
        assertTrue("Sex supplier cannot return null or blank sex", StringUtils.isNotBlank(Random.sex.get()));
    }

    /**
     * Test method for {@link com.ds.utils.Random#uuid()}.
     */
    @Test
    public void testUuid() {
        assertNotNull("Random generated UUID cannot found null", Random.uuid());
    }

    /**
     * Test method for {@link com.ds.utils.Random#indianName()}.
     */
    @Test
    public void testIndianName() {
        assertTrue("Random Indian Name cannot be null or empty", StringUtils.isNotBlank(Random.indianName()));
    }

    /**
     * Test method for {@link com.ds.utils.Random#englishName()}.
     */
    @Test
    public void testEnglishName() {
        assertTrue("Random English Name cannot be null or empty", StringUtils.isNotBlank(Random.englishName()));
    }

    /**
     * Test method for {@link com.ds.utils.Random#phoneNumber()}.
     */
    @Test
    public void testPhoneNumber() {
        final String phoneNumber = Random.phoneNumber();
        System.out.println(phoneNumber);
        assertNotNull("Random generated phone number found null", phoneNumber);
    }

    /**
     * Test method for {@link com.ds.utils.Random#id()}.
     */
    @Test
    public void testId() {
        assertNotNull("Random generated ID found null", Random.id());
    }

    /**
     * Test method for {@link com.ds.utils.Random#age(int, int)}.
     */
    @Test
    public void testAge() {
        final int age = Random.age(18, 60);
        assertNotNull("Random generated age found null", age);
        assertTrue("Random generated age should be between 18 and 60", age >= 18 && age <= 60);
    }

    /**
     * Test method for {@link com.ds.utils.Random#element(java.util.List)}.
     */
    @Test
    public void testElement() {
        final List<String> names = Stream.generate(() -> Random.indianName())
                                         .limit(10)
                                         .collect(Collectors.toList());
        final String name = Random.element(names);
        assertNotNull("Random Element found null", name);
        assertTrue("Random Element not present in source collection", names.contains(name));
    }

    /**
     * Test method for {@link com.ds.utils.Random#integers(int, int)}.
     */
    @Test
    public void testIntegers() {
        final Set<Integer> randomInts = Random.integers(100, 10);
        assertNotNull("Random Integers generated as null", randomInts);
        assertTrue("10 Random integers should have been generated", randomInts.size() == 10);
        randomInts.forEach(i -> assertTrue("Random integer is greater than 100", i < 100));
    }

    /**
     * Test method for {@link com.ds.utils.Random#elements(java.util.List, int)}.
     */
    @Test
    public void testElements() {
        final List<String> names = Stream.generate(() -> Random.indianName())
                                         .limit(10)
                                         .collect(Collectors.toList());
        final List<String> randomNames = Random.elements(names, 5);
        assertNotNull("Random names generated as null", randomNames);
        assertTrue("5 Random names should be picked", randomNames.size() == 5);
        randomNames.forEach(name -> assertTrue("random name not present in source collection", names.contains(name)));

    }

}
