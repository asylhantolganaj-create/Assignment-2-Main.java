import java.util.Scanner;

public class Main {
    /** Entry point – displays main menu and handles user selection. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<Integer> stack = new MyStack<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Work with MyStack");
            System.out.println("2. Work with MyQueue");
            System.out.println("3. Work with MyMinHeap");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    stackMenu(scanner, stack);
                    break;
                case 2:
                    queueMenu(scanner, queue);
                    break;
                case 3:
                    heapMenu(scanner, heap);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    /** Handles the interactive menu for stack operations. */
    private static void stackMenu(Scanner scanner, MyStack<Integer> stack) {
        while (true) {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Size");
            System.out.println("5. Is Empty?");
            System.out.println("6. Show all elements");
            System.out.println("0. Back to main");
            System.out.print("Choose: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Enter integer to push: ");
                    int val = scanner.nextInt();
                    stack.push(val);
                    System.out.println("Pushed.");
                    break;
                case 2:
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Top: " + stack.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Size: " + stack.size());
                    break;
                case 5:
                    System.out.println("Empty? " + stack.isEmpty());
                    break;
                case 6:
                    System.out.print("Stack contents (bottom to top): ");
                    Object[] arr = stack.toArray();
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                        if (i < arr.length - 1) System.out.print(", ");
                    }
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /** Handles the interactive menu for queue operations. */
    private static void queueMenu(Scanner scanner, MyQueue<Integer> queue) {
        while (true) {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Size");
            System.out.println("5. Is Empty?");
            System.out.println("6. Show all elements");
            System.out.println("0. Back to main");
            System.out.print("Choose: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Enter integer to enqueue: ");
                    int val = scanner.nextInt();
                    queue.enqueue(val);
                    System.out.println("Enqueued.");
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued: " + queue.dequeue());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Front: " + queue.peek());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Size: " + queue.size());
                    break;
                case 5:
                    System.out.println("Empty? " + queue.isEmpty());
                    break;
                case 6:
                    System.out.print("Queue contents (front to back): ");
                    Object[] arr = queue.toArray();
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                        if (i < arr.length - 1) System.out.print(", ");
                    }
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /** Handles the interactive menu for min-heap operations. */
    private static void heapMenu(Scanner scanner, MyMinHeap<Integer> heap) {
        while (true) {
            System.out.println("\n--- MIN HEAP MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Extract Min");
            System.out.println("3. Peek Min");
            System.out.println("4. Size");
            System.out.println("5. Is Empty?");
            System.out.println("6. Show all elements");
            System.out.println("0. Back to main");
            System.out.print("Choose: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Enter integer to insert: ");
                    int val = scanner.nextInt();
                    heap.insert(val);
                    System.out.println("Inserted.");
                    break;
                case 2:
                    try {
                        System.out.println("Extracted min: " + heap.extractMin());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Min: " + heap.peekMin());
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Size: " + heap.size());
                    break;
                case 5:
                    System.out.println("Empty? " + heap.isEmpty());
                    break;
                case 6:
                    System.out.print("Heap contents (level order): ");
                    Object[] arr = heap.toArray();
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i]);
                        if (i < arr.length - 1) System.out.print(", ");
                    }
                    System.out.println();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
