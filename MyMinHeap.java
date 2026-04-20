/**
 * Min-heap implemented using MyArrayList.
 * The smallest element is always at the root.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> heap;

    /** Creates an empty min-heap. */
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    /** Inserts a new element into the heap and restores the heap property. */
    public void insert(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    /** Returns an array of all elements in level order (not necessarily sorted). */
    public Object[] toArray() {
        return heap.toArray();
    }

    /** Removes and returns the minimum element (root) of the heap. */
    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.removeLast();
        if (!isEmpty()) {
            siftDown(0);
        }
        return min;
    }

    /** Returns the minimum element without removing it. */
    public T peekMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    /** Returns true if the heap contains no elements. */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /** Returns the number of elements in the heap. */
    public int size() {
        return heap.size();
    }

    /** Moves an element up the heap until the heap property is restored. */
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            T current = heap.get(index);
            T parentVal = heap.get(parent);
            if (current.compareTo(parentVal) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /** Moves an element down the heap until the heap property is restored. */
    private void siftDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    /** Swaps two elements in the heap array. */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
