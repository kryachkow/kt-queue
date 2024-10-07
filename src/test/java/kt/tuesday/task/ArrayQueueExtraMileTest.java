package kt.tuesday.task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayQueueExtraMileTest {
    @DisplayName("Test iterator with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testIterator(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(values);
        Iterator<Integer> iterator = queue.iterator();
        for (Integer value : values) {
            assertTrue(iterator.hasNext());
            assertEquals(value, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @DisplayName("Test toArray with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testToArray(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(values);
        Object[] array = queue.toArray();
        assertEquals(values.size(), array.length);
        for (int i = 0; i < values.size(); i++) {
            assertEquals(values.get(i), array[i]);
        }
    }

    @DisplayName("Test remove with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testRemove(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(values);
        for (Integer value : values) {
            assertTrue(queue.remove(value));
            assertFalse(queue.contains(value));
        }
    }

    @DisplayName("Test containsAll with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testContainsAll(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(values);
        assertTrue(queue.containsAll(values));
    }

    @DisplayName("Test addAll with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testAddAll(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        assertTrue(queue.addAll(values));
        assertTrue(queue.containsAll(values));
    }

    @DisplayName("Test removeAll with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testRemoveAll(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(values);
        assertTrue(queue.removeAll(values));
        assertTrue(queue.isEmpty());
    }

    @DisplayName("Test retainAll with different values")
    @ParameterizedTest
    @MethodSource("provideTestValues")
    void testRetainAll(List<Integer> values) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(values.size());
        queue.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertTrue(queue.retainAll(values));
        assertEquals(3, queue.size());
    }

    static Stream<List<Integer>> provideTestValues() {
        return Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
    }
}
