package kt.tuesday.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Your task is implement circular list
 * Circular list is an array with a pointer
 * Method next should return next value after pointer and place it after returned value
 * Method previous should return previous value before pointer and place it before returned value
 * Initially pointer starts between first and last values
 * Example:
 * Array values are [1,2,3]
 * Pointer initially  ..2, 3, |  1, 2, 3...
 * From this position after if next called 1 is returned and pointer placed ... 1, |  2, 3...
 * From same position after if previous called 3 is returned and pointer placed ...2, | 3, 1,...
 */
public class CircularList<T> {

    final private T[] elements;
    private int index = -1;

    public CircularList(final T... elements) {
        this.elements = elements;

    }

    T next() {
        index = (++index + elements.length) % elements.length;
        return elements[index];
    }

    T previous() {
        T elem = elements[(index-- + elements.length) % elements.length];
        index = (index + elements.length) % elements.length;
        return elem;
    }
}