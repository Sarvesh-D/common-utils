/*******************************************************************************
 * Copyright 2018 Sarvesh Dubey <https://github.com/Sarvesh-D/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.ds.utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

/**
 * Utility class for dealing with {@link Collection}
 *
 * @author Sarvesh Dubey <https://github.com/Sarvesh-D/>
 * @since 16 Jun 2018
 * @version 1.0
 */
public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T> T randomElem(final List<T> elems) {
        return Random.element(elems);
    }

    public static <T> List<T> randomElems(final List<T> elems, final int count) {
        return Stream.generate(() -> randomElem(elems))
                     .limit(count)
                     .collect(Collectors.toList());
    }

    public static <T> void removeRandomElem(final List<T> input) {
        Assert.assertNotNull("Input collection cannot be null", input);
        removeRandomElems(input, 1);
    }

    public static <T> void removeRandomElems(final List<T> input, final int count) {
        Assert.assertTrue("Count cannot be greater than number of elements", count <= input.size());
        final Set<Integer> indicesToRemove = Random.integers(input.size(), count);
        input.removeAll(indicesToRemove.stream()
                                       .map(input::get)
                                       .collect(Collectors.toList()));
    }

    public static <T> List<T> getElems(final List<T> input, final T toFind) {
        Assert.assertNotNull("Input collection cannot be null", input);
        Assert.assertNotNull("Target element cannot be null", toFind);
        return input.stream()
                    .filter(elem -> (toFind.hashCode() == elem.hashCode() && toFind.equals(elem)))
                    .collect(Collectors.toList());
    }

    public static <T> Optional<T> getElem(final List<T> input, final T toFind) {
        Assert.assertNotNull("Input collection cannot be null", input);
        Assert.assertNotNull("Target element cannot be null", toFind);
        return input.stream()
                    .filter(elem -> (toFind.hashCode() == elem.hashCode() && toFind.equals(elem)))
                    .findFirst();
    }

}
