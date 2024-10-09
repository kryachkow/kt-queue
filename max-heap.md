# What is a Max-Heap?

_A Max-Heap is a complete binary tree where each node is greater than or equal to its children. This ensures that the
largest element is always at the root. Max-heaps are commonly used to implement priority queues._

## Properties of a Max-Heap:

**Complete Binary Tree:** _All levels are fully filled except possibly the last level, which is filled from left to
right._

**Heap Property:** _For any given node i, the value of i is greater than or equal to the values of its children._

## Array Representation:

_A max-heap can be efficiently represented as an array:_

**Root:** _The root element is at index 0._

**Parent:** _For any element at index i, the parent is at index (i - 1) / 2._

**Left Child:** _For any element at index i, the left child is at index 2*i + 1._

**Right Child:** _For any element at index i, the right child is at index 2*i + 2._

## Operations on a Max-Heap:

### Insertion (add):

1. Add the new element at the end of the array.
2. Restore the heap property by "heapifying up".

### Removal (poll):

1. Remove the root element (the maximum element).
2. Replace the root with the last element in the array.
3. Restore the heap property by "heapifying down".

### Peek (peek):

1. Return the root element without removing it.

## Heapify Up:

1. Compare the added element with its parent.
2. If the added element is larger, swap it with its parent.
3. Repeat until the element is at the root or the parent is larger.

## Heapify Down:

1. Compare the root element with its children.
2. If the root is smaller than the larger child, swap it with the larger child.
3. Repeat until the element is at a leaf or both children are smaller.

### Example:

Let's illustrate the max-heap operations with an example:

**Initial Max-Heap:** [ ]

**Insert** 10:

**Heap:** [10]

**Insert** 15:

1. **Add 15 at the end:** [10, 15]
2. Heapify up: Swap 15 with 10: [15, 10]
3. Heap: [15, 10]

**Insert 20:**

1. Add 20 at the end: [15, 10, 20]
2. Heapify up: Swap 20 with 15: [20, 10, 15]
3. Heap: [20, 10, 15]

**Insert 17:**

1. Add 17 at the end: [20, 10, 15, 17]
2. Heapify up: Swap 17 with 10: [20, 17, 15, 10]
3. Heap: [20, 17, 15, 10]

**Insert 8:**

1. Heap: [20, 17, 15, 10, 8]

**Remove the root (20):**

1. Remove 20:
2. Replace root with last element: [8, 17, 15, 10]
3. Heapify down: Swap 8 with 17: [17, 8, 15, 10]
4. Heapify down: Swap 8 with 10: [17, 10, 15, 8]
5. Heap: [17, 10, 15, 8]