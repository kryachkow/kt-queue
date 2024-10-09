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
     * 1. Extract root item
     * 2. Set last item as root
     * 3. Decrement size variable
     * 4. heapifyDown()
     * 5. return extracted item
     *
     * @return the maximum element that was removed from the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int poll() {
        throw new TaskNotCompletedException();
    }

    /**
     * Adds a new element to the heap and maintains the heap property.
     * 1. Double capacity if current size equals to capacity
     * 2. Set item to end of array
     * 3. Increment size variable
     * 4. heapifyUp()
     *
     * @param item the element to be added to the heap.
     */
    public void add(int item) {
        throw new TaskNotCompletedException();
    }

    /**
     * Restores the heap property by "heapifying up" from the last element.
     * <p>
     * Step-by-step:
     * 1. Start with the last element (newly added element).
     * 2. Compare the element with its parent.
     * 3. If the element is larger than its parent, swap them.
     * 4. Repeat the process until the element is at the root or the parent is larger.
     */
    private void heapifyUp() {
        throw new TaskNotCompletedException();
    }

    /**
     * Restores the heap property by "heapifying down" from the root element.
     * <p>
     * Step-by-step:
     * 1. Start with the root element.
     * 2. In loop compare the element with its children.
     * 3. If the element is smaller than the larger child, swap them.
     * 3a. If the element is larger than lagrer child break the loop
     * 4. Repeat the process until the element is at a leaf or both children are smaller.
     */
    private void heapifyDown() {
        throw new TaskNotCompletedException();
    }
}
