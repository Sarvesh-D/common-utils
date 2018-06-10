package com.ds.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

import com.github.javafaker.Faker;

public class Random {

    private static final java.util.Random RANDOM = new java.util.Random();

    private static final Faker IND_FAKER = new Faker(new Locale("en-IND"));

    private static final Faker US_FAKER = new Faker(new Locale("en-US"));

    private Random() {
    }

    public static final Supplier<String> firstName = () -> IND_FAKER.name()
                                                                    .firstName();

    public static final Supplier<String> lastName = () -> IND_FAKER.name()
                                                                   .lastName();

    public static final Supplier<String> city = () -> IND_FAKER.address()
                                                               .city();

    public static final Supplier<String> sex = () -> element(Arrays.asList("Male", "Female"));

    public static UUID uuid() {
        return UUID.randomUUID();
    }

    public static String indianName() {
        return IND_FAKER.name()
                        .fullName();
    }

    public static String englishName() {
        return US_FAKER.name()
                       .fullName();
    }

    public static String phoneNumber() {
        return IND_FAKER.phoneNumber()
                        .phoneNumber();
    }

    public static long id() {
        return IND_FAKER.number()
                        .randomNumber();
    }

    public static int age(final int min, final int max) {
        return IND_FAKER.number()
                        .numberBetween(min, max);
    }

    public static <T> T element(final List<T> elems) {
        return elems.get(RANDOM.nextInt(elems.size()));
    }

    public static Set<Integer> integers(final int endExclusive, final int count) {
        final Supplier<Integer> intSupplier = () -> RANDOM.nextInt(endExclusive);
        final Set<Integer> uniqueRandomInts = new HashSet<>();
        while (count != uniqueRandomInts.size()) {
            uniqueRandomInts.add(intSupplier.get());
        }
        return uniqueRandomInts;
    }

    public static <T> List<T> elements(final List<T> elems, final int count) {
        Assert.assertNotNull("Input elements cannot be null", null != elems);
        Assert.assertTrue("Count cannot be greater than number of elements", count <= elems.size());
        final Supplier<T> randomElemSupplier = () -> element(elems);
        return Stream.generate(randomElemSupplier)
                     .limit(count)
                     .collect(Collectors.toList());
    }

}
