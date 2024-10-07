package kt.tuesday.task;

import kt.tuesday.exception.TaskNotCompletedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * An ArrayQueue implementation from scratch in Java.
 * This class uses a circular buffer to store its elements.
 * (there is a chance of head = 8 tail = 2 for 10 capacity array that means current deck indexes are (positions 8, 9, 0, 1))
 * Both enqueue (add/offer) and dequeue (remove/poll) operations are O(1) operations(If there is no resize)
 * Null objects are prohibited for this queue.
 */
public class ArrayQueue<T> implements Queue<T> {

    private final Object[] elements;

    /**
     * Constructs an empty array queue with an initial capacity.
     * The capacity is the length of the internal array used to store elements.
     *
     * @param initialCapacity the initial capacity of the queue
     */
    public ArrayQueue(int initialCapacity) {
        throw new TaskNotCompletedException();
    }

    /**
     * Doubles the capacity of the queue's internal array.
     * This method is called when the queue is full and needs to grow.
     * <p>
     * 1) Create a new array with twice the capacity of the current array.</li>
     * 2) If the head index is less than the tail index, copy all elements from the head index to the tail index from the old array to the new array.
     * 3) If the head index is greater than or equal to the tail index, copy the elements in two parts:
     * a) Copy the elements from the head index to the end of the old array to the start of the new array.
     * b) Copy the elements from the start of the old array to the tail index to the new array, starting from the position after the last copied element.
     * 4) Replace the old array with the new array.
     * 5) Reset the head index to 0.
     * 6) Set the tail index to the size of the queue (the number of elements), which is the position where the next element will be added.
     */
    private void doubleCapacity() {
        throw new TaskNotCompletedException();
    }

    /**
     * Returns the number of elements in this queue.
     * The size is calculated as the difference between head and tail, modulo(%) the length of the elements array.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        throw new TaskNotCompletedException();
    }

    /**
     * Returns true if this queue contains no elements.
     * This is determined by checking if the head and tail pointers point to the same position.
     *
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        throw new TaskNotCompletedException();
    }

    /**
     * Returns true if this queue contains the specified element.
     * This method iterates over the elements in the queue, comparing each element with the given object.
     *
     * @param o element whose presence in this queue is to be tested
     * @return true if this queue contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        throw new TaskNotCompletedException();
    }

    /**
     * Removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     * This is achieved by setting all elements in the array to null, and resetting the head and tail pointers to zero.
     */
    @Override
    public void clear() {
        throw new TaskNotCompletedException();
    }

    /**
     * Inserts the specified element into this queue.
     * The element is inserted at the tail of the queue.
     * The tail pointer is then moved one position to the right, wrapping around to the start of the array if necessary.
     * If the queue is full (head equals tail), the capacity of the queue is doubled.
     *
     * @param t the element to add
     * @return true (as specified by Collection.add(E))
     * @throws NullPointerException if t is null
     */
    @Override
    public boolean add(T t) {
        throw new TaskNotCompletedException();
    }


    /**
     * Inserts the specified element into this queue if it is possible.
     * This method is equivalent to add(E).
     * If add(T t) throws an exception false is returned
     *
     * @param t the element to add
     * @return true if the element was added to this queue, else false
     */
    @Override
    public boolean offer(T t) {
        throw new TaskNotCompletedException();
    }

    /**
     * Retrieves and removes the head of this queue.
     * This is achieved by storing the element at the head position, setting that position to null, and moving the head pointer one position to the right.
     *
     * @return the head of the queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public T remove() {
        throw new TaskNotCompletedException();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * This is achieved by storing the element at the head position, setting that position to null, and moving the head pointer one position to the right.
     *
     * @return the head of the queue, or null if this queue is empty
     */
    @Override
    public T poll() {
        throw new TaskNotCompletedException();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This is achieved by simply returning the element at the head position.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public T element() {
        throw new TaskNotCompletedException();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * This is achieved by simply returning the element at the head position, or null if the queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public T peek() {
        throw new TaskNotCompletedException();
    }

    // The following methods are not implemented and will throw an UnsupportedOperationException
    // If you finished task early you can implement this as an extra mile

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
