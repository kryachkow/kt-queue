package kt.thursday.warmup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeapUtilsTest {

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 1",
            "4, 1"
    })
    @DisplayName("Test getParentIndex method")
    void testGetParentIndex(int index, int expectedParentIndex) {
        assertEquals(expectedParentIndex, HeapUtils.getParentIndex(index),
                "Parent index of " + index + " should be " + expectedParentIndex);
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource({
            "0, 1",
            "1, 3",
            "2, 5"
    })
    @DisplayName("Test getLeftChildIndex method")
    void testGetLeftChildIndex(int index, int expectedLeftChildIndex) {
        assertEquals(expectedLeftChildIndex, HeapUtils.getLeftChildIndex(index),
                "Left child index of " + index + " should be " + expectedLeftChildIndex);
    }

    @ParameterizedTest
    @Order(3)
    @CsvSource({
            "0, 2",
            "1, 4",
            "2, 6"
    })
    @DisplayName("Test getRightChildIndex method")
    void testGetRightChildIndex(int index, int expectedRightChildIndex) {
        assertEquals(expectedRightChildIndex, HeapUtils.getRightChildIndex(index),
                "Right child index of " + index + "should be " + expectedRightChildIndex);
    }

    @ParameterizedTest
    @Order(4)
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("Test hasParent method")
    void testHasParent(int index) {
        assertTrue(HeapUtils.hasParent(index),
                "Index " + index + " should have a parent");
    }

    @ParameterizedTest
    @Order(5)
    @ValueSource(ints = {0})
    @DisplayName("Test hasParent method for root")
    void testHasParentRoot(int index) {
        assertFalse(HeapUtils.hasParent(index),
                "Root index " + index + " should not have a parent");
    }

    @ParameterizedTest
    @Order(6)
    @CsvSource({
            "0, 3, true",
            "1, 3, false",
            "2, 3, false"
    })
    @DisplayName("Test hasLeftChild method")
    void testHasLeftChild(int index, int size, boolean expected) {
        assertEquals(expected, HeapUtils.hasLeftChild(index, size),
                "Index " + index + " with size " + size + " should have left child: " + expected);
    }

    @ParameterizedTest
    @Order(7)
    @CsvSource({
            "0, 3, true",
            "1, 3, false",
            "2, 3, false"
    })
    @DisplayName("Test hasRightChild method")
    void testHasRightChild(int index, int size, boolean expected) {
        assertEquals(expected, HeapUtils.hasRightChild(index, size),
                "Index " + index + " with size " + size + " should have right child: " + expected);
    }

    @ParameterizedTest
    @Order(8)
    @CsvSource({
            "1, 0, 10",
            "2, 0, 20",
            "3, 1, 30"
    })
    @DisplayName("Test parent method")
    void testParent(int index, int parentIndex, int parentValue) {
        int[] heap = new int[parentIndex + 1];
        heap[parentIndex] = parentValue;
        assertEquals(parentValue, HeapUtils.parent(heap, index),
                "Parent value of index " + index + " should be " + parentValue);
    }

    @ParameterizedTest
    @Order(9)
    @CsvSource({
            "0, 1, 10, 20",
            "1, 3, 20, 30",
            "2, 5, 30, 40"
    })
    @DisplayName("Test leftChild method")
    void testLeftChild(int index, int leftChildIndex, int parentValue, int leftChildValue) {
        int[] heap = new int[leftChildIndex + 1];
        heap[index] = parentValue;
        heap[leftChildIndex] = leftChildValue;
        assertEquals(leftChildValue, HeapUtils.leftChild(heap, index),
                "Left child value of index " + index + " should be " + leftChildValue);
    }

    @ParameterizedTest
    @Order(10)
    @CsvSource({
            "0, 2, 10, 20",
            "1, 4, 20, 30",
            "2, 6, 30, 40"
    })
    @DisplayName("Test rightChild method")
    void testRightChild(int index, int rightChildIndex, int parentValue, int rightChildValue) {
        int[] heap = new int[rightChildIndex + 1];
        heap[index] = parentValue;
        heap[rightChildIndex] = rightChildValue;
        assertEquals(rightChildValue, HeapUtils.rightChild(heap, index),
                "Right child value of index " + index + " should be " + rightChildValue);
    }

    @Test
    @Order(11)
    @DisplayName("Test swap method")
    void testSwap() {
        int[] heap = {10, 20};
        HeapUtils.swap(heap, 0, 1);
        assertAll(
                () -> assertEquals(20, heap[0], "After swap, value at index 0 should be 20"),
                () -> assertEquals(10, heap[1], "After swap, value at index 1 should be 10")
        );
    }
}
