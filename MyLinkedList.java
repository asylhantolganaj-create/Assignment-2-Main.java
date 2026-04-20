import java.util.Iterator;

/**
 * Doubly linked list implementation of MyList.
 * Provides O(1) add/remove at ends, O(n) access by index.
 */
public class MyLinkedList<T> implements MyList<T> {

    private static class MyNode<T> {
        T data;
        MyNode<T> prev;
        MyNode<T> next;
        MyNode(T data, MyNode<T> prev, MyNode<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    /** Constructs an empty linked list. */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /** Throws exception if index is out of bounds. */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /** Returns the node at the given index, traversing from the nearest end. */
    private MyNode<T> nodeAt(int index) {
        if (index < size / 2) {
            MyNode<T> cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
            return cur;
        } else {
            MyNode<T> cur = tail;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
            return cur;
        }
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        nodeAt(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode<T> succ = nodeAt(index);
            MyNode<T> pred = succ.prev;
            MyNode<T> newNode = new MyNode<>(item, pred, succ);
            pred.next = newNode;
            succ.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item, null, head);
        if (head == null) tail = newNode;
        else head.prev = newNode;
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item, tail, null);
        if (tail == null) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) removeFirst();
        else if (index == size - 1) removeLast();
        else {
            MyNode<T> toRemove = nodeAt(index);
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /** Sorts using bubble sort by swapping node data (not links). */
    @Override
    public void sort() {
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            MyNode<T> cur = head;
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) cur.data;
                T b = cur.next.data;
                if (a.compareTo(b) > 0) {
                    T temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int idx = 0;
        for (MyNode<T> cur = head; cur != null; cur = cur.next) {
            if (object == null ? cur.data == null : object.equals(cur.data))
                return idx;
            idx++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int idx = size - 1;
        for (MyNode<T> cur = tail; cur != null; cur = cur.prev) {
            if (object == null ? cur.data == null : object.equals(cur.data))
                return idx;
            idx--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (MyNode<T> cur = head; cur != null; cur = cur.next)
            arr[i++] = cur.data;
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /** Returns an iterator over the elements in this list. */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) throw new IllegalStateException("No more elements");
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
