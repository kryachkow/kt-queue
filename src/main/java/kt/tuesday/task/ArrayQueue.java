package kt.tuesday.task;

import kt.exception.TaskNotCompletedException;

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
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        throw new TaskNotCompletedException();
    }

    /**
     * Returns true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        throw new TaskNotCompletedException();
    }

    /**
     * Returns true if this queue contains the specified element.
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
     */
    @Override
    public void clear() {
        throw new TaskNotCompletedException();
    }

    /**
     * Inserts the specified element into this queue.
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
     *
     * @return the head of the queue, or null if this queue is empty
     */
    @Override
    public T poll() {
        throw new TaskNotCompletedException();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
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
        throw new TaskNotCompletedException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new TaskNotCompletedException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new TaskNotCompletedException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new TaskNotCompletedException();
    }

    @Override
    public Object[] toArray() {
        throw new TaskNotCompletedException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new TaskNotCompletedException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new TaskNotCompletedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new TaskNotCompletedException();
    }
}
