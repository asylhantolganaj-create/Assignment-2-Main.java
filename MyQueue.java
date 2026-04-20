/**
 * Queue (FIFO) implemented using MyLinkedList.
 * Enqueue and dequeue run in O(1) time.
 */
public class MyQueue<T> {
    private final MyLinkedList<T> list;

    /** Creates an empty queue. */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /** Adds an element to the back of the queue. */
    public void enqueue(T item) {
        list.addLast(item);
    }

    /** Removes and returns the front element of the queue. */
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    /** Returns the front element without removing it. */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    /** Returns true if the queue contains no elements. */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /** Returns the number of elements in the queue. */
    public int size() {
        return list.size();
    }

    /** Returns an array containing all elements in the queue (front to back). */
    public Object[] toArray() {
        return list.toArray();
    }
}
