
public class MyStack<T> {
    private final MyArrayList<T> list;

    /** Creates an empty stack. */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /** Pushes an element onto the top of the stack. */
    public void push(T item) {
        list.addLast(item);
    }

    /** Removes and returns the top element of the stack. */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    /** Returns the top element without removing it. */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    /** Returns true if the stack contains no elements. */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /** Returns the number of elements in the stack. */
    public int size() {
        return list.size();
    }

    /** Returns an array containing all elements in the stack (bottom to top). */
    public Object[] toArray() {
        return list.toArray();
    }
}
