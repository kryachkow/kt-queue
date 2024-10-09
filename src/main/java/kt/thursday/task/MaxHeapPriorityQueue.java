package kt.thursday.task;

import java.util.Arrays;

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
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }


    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasParent(int index) {
        return index > 0 && getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int parent(int index) {
        return heap[getParentIndex(index)];
    }

    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * Returns the maximum element (root) of the heap without removing it.
     *
     * @return the maximum element in the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
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
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int item = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return item;
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
        ensureExtraCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
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
        int index = size - 1;
        while (hasParent(index) && parent(index) < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
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
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }

            if (heap[index] > heap[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
}
