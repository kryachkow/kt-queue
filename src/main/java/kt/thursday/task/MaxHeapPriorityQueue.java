package kt.thursday.task;

import kt.exception.TaskNotCompletedException;

/**
 * A Max-Heap based Priority Queue implementation in Java.
 */
public class MaxHeapPriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    /**
     * Constructor to initialize the priority queue with a given capacity.
     *
     * @param capacity the initial capacity of the priority queue.
     */
    public MaxHeapPriorityQueue(int capacity) {

    }

    /**
     * Returns the maximum element (root) of the heap without removing it.
     *
     * @return the maximum element in the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int peek() {
        throw new TaskNotCompletedException();
    }

    /**
     * Removes and returns the maximum element (root) of the heap.
     *
     * @return the maximum element that was removed from the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int poll() {
        throw new TaskNotCompletedException();
    }

    /**
     * Adds a new element to the heap and maintains the heap property.
     *
     * @param item the element to be added to the heap.
     */
    public void add(int item) {
        throw new TaskNotCompletedException();
    }

    /**
     * Restores the heap property by "heapifying up" from the last element.
     */
    private void heapifyUp() {
        throw new TaskNotCompletedException();
    }

    /**
     * Restores the heap property by "heapifying down" from the root element.
     */
    private void heapifyDown() {
        throw new TaskNotCompletedException();
    }
}
