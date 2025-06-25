public class SupermarketQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public SupermarketQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;  // Fixed: rear starts at -1 for circular queue
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int customerId) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add customer " + customerId);
        } else {
            rear = (rear + 1) % capacity;  // Circular increment
            queue[rear] = customerId;
            size++;
            System.out.println("Customer " + customerId + " added to the queue.");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. No customers to serve.");
            return -1;
        } else {
            int servedCustomer = queue[front];
            front = (front + 1) % capacity;  // Circular increment
            size--;
            System.out.println("Served customer " + servedCustomer);
            return servedCustomer;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Current queue: ");
            int current = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queue[current] + " ");
                current = (current + 1) % capacity;
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    // Main program with menu
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter queue capacity: ");
        int capacity = scanner.nextInt();
        SupermarketQueue queue = new SupermarketQueue(capacity);

        while (true) {
            System.out.println("\nSupermarket Queue Management");
            System.out.println("a. Add customer");
            System.out.println("b. Serve next customer");
            System.out.println("c. Display queue");
            System.out.println("d. Display queue size");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    System.out.print("Enter customer ID: ");
                    int id = scanner.nextInt();
                    queue.enqueue(id);
                    break;
                case 'b':
                    queue.dequeue();
                    break;
                case 'c':
                    queue.displayQueue();
                    break;
                case 'd':
                    System.out.println("Customers in queue: " + queue.getSize());
                    break;
                case 'e':
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
