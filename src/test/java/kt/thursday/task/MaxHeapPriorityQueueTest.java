package kt.thursday.task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MaxHeapPriorityQueueTest {

    @Test
    @Order(1)
    @DisplayName("Test adding a single element to the heap")
    void testAddSingleElement() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(10);
        assertEquals(10, pq.peek(), "The root element should be 10 after adding 10. Check peek() method");
    }

    @Test
    @Order(2)
    @DisplayName("Test adding multiple elements to the heap")
    void testAddMultipleElements() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(15);
        pq.add(15);
        pq.add(10);
        assertEquals(15, pq.peek(), "The root element should be 15 after adding 15, 15, and 10. Check peek() and heapifyUp() methods");
    }

    @Test
    @Order(3)
    @DisplayName("Test polling the root element from the heap")
    void testPollRootElement() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(10);
        pq.add(22);
        pq.add(10);
        assertEquals(22, pq.poll(), "The polled element should be 22. Check poll() and heapifyUp() methods");
    }

    @Test
    @Order(4)
    @DisplayName("Test polling the root element and checking new root")
    void testPollRootAndCheckNewRoot() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(10);
        pq.add(15);
        pq.add(20);
        pq.poll();
        assertEquals(15, pq.peek(), "The root element should be 15 after polling 20. Check heapifyDown() method");
    }

    @Test
    @Order(5)
    @DisplayName("Test polling all elements from the heap")
    void testPollAllElements() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(10);
        pq.add(15);
        pq.add(20);
        pq.poll();
        pq.poll();
        assertEquals(10, pq.poll(), "The third polled element should be 10.");
    }


    @Test
    @Order(6)
    @DisplayName("Test peeking from an empty heap")
    void testPeekEmptyHeap() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::peek);
        assertEquals("Heap is empty", exception.getMessage(), "Peeking from an empty heap should throw an IllegalStateException.");
    }

    @Test
    @Order(7)
    @DisplayName("Test polling from an empty heap")
    void testPollEmptyHeap() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        Exception exception = assertThrows(IllegalStateException.class, pq::poll);
        assertEquals("Heap is empty", exception.getMessage(), "Polling from an empty heap should throw an IllegalStateException.");
    }

    @ParameterizedTest
    @Order(8)
    @ValueSource(ints = {10, 15, 20, 25, 30})
    @DisplayName("Test adding multiple elements using ParameterizedTest")
    void testAddParameterized(int value) {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.add(value);
        assertEquals(value, pq.peek(), "The root element should be " + value + " after adding " + value + ".");
    }

    @Test
    @Order(9)
    @DisplayName("Test ensuring extra capacity")
    void testEnsureExtraCapacity() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(2);
        pq.add(10);
        pq.add(15);
        pq.add(20);
        pq.poll();
        pq.poll();
        assertEquals(10, pq.poll(), "The root element should be 10 after adding 10, 15, and 20 with initial capacity 2 and polling 20 and 15 before.");
    }

    @Test
    @Order(10)
    @DisplayName("Complex multi assertion test")
    void multiAssertionTest() {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(2);
        pq.add(17);
        pq.add(45);
        pq.add(45);
        pq.add(14);
        pq.add(22);
        pq.add(3);
        pq.add(66);
        assertEquals(66, pq.poll(), "1st root should be 66 as a biggest number");
        assertEquals(45, pq.poll(), "2nd and 3rd root should return 45");
        assertEquals(45, pq.poll(), "2nd and 3rd root should return 45");
        assertEquals(22, pq.poll(), "4th root should be 22");
        assertEquals(17, pq.poll(), "5th root should be 17");
        assertEquals(14, pq.poll(), "6th root should be 14");
        assertEquals(3, pq.poll(), "7th root should be 3");

    }
}