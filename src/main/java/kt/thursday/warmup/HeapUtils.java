package kt.thursday.warmup;

public class HeapUtils {

    /**
     * Methods return parent/leftChild/rightChild indexes for passed index
     * <p>
     * If there is no parent "0" is returned
     */
    public static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * Methods return true if parent/leftChild/rightChild exists
     */
    public static boolean hasParent(int index) {
        return index > 0 && getParentIndex(index) >= 0;
    }

    public static boolean hasLeftChild(int index, int size) {
        return getLeftChildIndex(index) < size;
    }

    public static boolean hasRightChild(int index, int size) {
        return getRightChildIndex(index) < size;
    }

    /**
     * Methods return parent/leftChild/rightChild value for passed index
     * <p>
     * Assume that has/hasLeftChild/hasRightChild is used and there is no chance of IndexOutOfBoundsException for next 4 methods
     */
    public static int parent(int[] heap, int index) {
        return heap[getParentIndex(index)];
    }

    public static int leftChild(int[] heap, int index) {
        return heap[getLeftChildIndex(index)];
    }

    public static int rightChild(int[] heap, int index) {
        return heap[getRightChildIndex(index)];
    }

    public static void swap(int[] heap, int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }
}
