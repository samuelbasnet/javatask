import java.util.Scanner;

public class CallCenterQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public CallCenterQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // a. Add an incoming call to the queue
    public void enqueue(String callId) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add call " + callId);
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = callId;
            size++;
            System.out.println("Call " + callId + " added to the queue.");
        }
    }

    // b. Serve and handle the next call in the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. No calls to serve.");
        } else {
            String callId = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Served call " + callId);
        }
    }

    // c. Display the current call queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Current call queue: ");
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queue[index] + " ");
                index = (index + 1) % capacity;
            }
            System.out.println();
        }
    }

    // d. Display the number of pending calls
    public void displaySize() {
        System.out.println("Number of pending calls: " + size);
    }

    // e. Exit the program (handled in main)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter call queue capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        CallCenterQueue queue = new CallCenterQueue(capacity);

        while (true) {
            System.out.println("\nCall Center Queue Management");
            System.out.println("a. Add incoming call");
            System.out.println("b. Serve next call");
            System.out.println("c. Display call queue");
            System.out.println("d. Display number of pending calls");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    System.out.print("Enter call ID: ");
                    String callId = scanner.nextLine();
                    queue.enqueue(callId);
                    break;
                case "b":
                    queue.dequeue();
                    break;
                case "c":
                    queue.displayQueue();
                    break;
                case "d":
                    queue.displaySize();
                    break;
                case "e":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

