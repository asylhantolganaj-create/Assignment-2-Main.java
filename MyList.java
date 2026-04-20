public interface MyList<T> extends Iterable<T> {
    // Basic operations
    void add(T item);                 // Append to end
    void set(int index, T item);      // Replace element at index
    void add(int index, T item);      // Insert at position

    // Add at ends
    void addFirst(T item);
    void addLast(T item);

    // Accessors
    T get(int index);
    T getFirst();
    T getLast();

    // Removal
    void remove(int index);
    void removeFirst();
    void removeLast();

    // Utility
    void sort();                      // Natural order (requires Comparable)
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object o);
    Object[] toArray();               // Copy as Object[]
    void clear();
    int size();
}
