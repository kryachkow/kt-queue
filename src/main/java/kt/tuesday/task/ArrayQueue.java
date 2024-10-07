package kt.tuesday.task;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/**
 * An ArrayQueue implementation from scratch in Java.
 * This class uses a circular buffer to store its elements.
 * (there is a chance of head = 8 tail = 2 for 10 capacity array that means current deck indexes are (positions 8, 9, 0, 1))
 * Both enqueue (add/offer) and dequeue (remove/poll) operations are O(1) operations(If there is no resize)
 * Null objects are prohibited for this queue.
 */
public class ArrayQueue<T> implements Queue<T> {
    private Object[] elements;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    /**
     * Constructs an empty array queue with an initial capacity.
     * The capacity is the length of the internal array used to store elements.
     *
     * @param initialCapacity the initial capacity of the queue
     */
    public ArrayQueue(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    /**
     * Returns the number of elements in this queue.
     * The size is calculated as the difference between head and tail, modulo(%) the length of the elements array.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this queue contains no elements.
     * This is determined by checking if the head and tail pointers point to the same position.
     *
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
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
        if (o == null) return false;
        for (int i = head; i != tail; i = (i + 1) % elements.length) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     * This is achieved by setting all elements in the array to null, and resetting the head and tail pointers to zero.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        head = 0;
        tail = 0;
        size = 0;
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
        Objects.requireNonNull(t);
        elements[tail] = t;
        tail = (tail + 1) % elements.length;
        size++;
        if (size == elements.length) doubleCapacity();
        return true;
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
        try {
            return add(t);
        } catch (NullPointerException e) {
            return false;
        }
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
        if (isEmpty()) throw new NoSuchElementException();
        T element = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * This is achieved by storing the element at the head position, setting that position to null, and moving the head pointer one position to the right.
     *
     * @return the head of the queue, or null if this queue is empty
     */
    @Override
    public T poll() {
        if (isEmpty()) return null;
        T element = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
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
        if (isEmpty()) throw new NoSuchElementException();
        return (T) elements[head];
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * This is achieved by simply returning the element at the head position, or null if the queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return (T) elements[head];
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
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        if (head < tail) {
            System.arraycopy(elements, head, newArray, 0, size);
        } else {
            System.arraycopy(elements, head, newArray, 0, elements.length - head);
            System.arraycopy(elements, 0, newArray, elements.length - head, tail);
        }
        elements = newArray;
        head = 0;
        tail = size;
    }


    // The following methods are not implemented and will throw an UnsupportedOperationException
    // If you finished task early you can implement this as an extra mile

    @Override
    public boolean remove(Object o) {
        for (int i = head; i != tail; i = (i + 1) % elements.length) {
            if (o.equals(elements[i])) {

                for (int j = i; j != tail; j = (j + 1) % elements.length) {
                    elements[j] = elements[(j + 1) % elements.length];
                }
                tail = (tail - 1 + elements.length) % elements.length;
                elements[tail] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[(head + i) % elements.length];
        }
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        int size = size();
        if (a.length < size) {
            a = (T1[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        for (int i = 0; i < size; i++) {
            a[i] = (T1) elements[(head + i) % elements.length];
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = head;
            private boolean canRemove = false;

            @Override
            public boolean hasNext() {
                return index != tail;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T element = (T) elements[index];
                index = (index + 1) % elements.length;
                canRemove = true;
                return element;
            }

            @Override
            public void remove() {
                if (!canRemove) {
                    throw new IllegalStateException();
                }
                index = (index - 1 + elements.length) % elements.length;
                int i = index;
                while (i != tail) {
                    elements[i] = elements[(i + 1) % elements.length];
                    i = (i + 1) % elements.length;
                }
                elements[tail] = null;
                tail = (tail - 1 + elements.length) % elements.length;
                size--;
                canRemove = false;
            }
        };
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
}
