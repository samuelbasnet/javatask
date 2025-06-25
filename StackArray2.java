public class StackArray2 {
    // You are tasked with implementing a stack data structure in Java without using any built-in libraries. Your goal is to create a CustomStack class that can handle various operations. The class should have the following functionalities:

// push(int val): Adds an integer value val to the top of the stack.

// pop(): Removes and returns the element at the top of the stack.

// peek(): Returns the element at the top of the stack without removing it.



// isEmpty(): Checks if the stack is empty and returns a boolean value indicating the result.

// isFull(): Checks if the stack is full and returns a boolean value indicating the result.

    public class CustomStack {
        private int[] stack;
        private int top;
        private int capacity;

        public CustomStack(int size) {
            stack = new int[size];
            capacity = size;
            top = -1; // Stack is initially empty
        }

        public boolean isEmpty() {
            return top == -1; // Stack is empty when top is at -1
        }

        public boolean isFull() {
            return top == capacity - 1; // Stack is full when top is at the last index
        }

        public void push(int val) {
            if (isFull()) {
                System.out.println("Stack is full. Cannot push " + val);
            } else {
                stack[++top] = val; // Increment top and add value to the stack
                System.out.println("Pushed " + val + " onto the stack.");
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow");
                return -9999; // Return a sentinel value or throw an exception
            } else {
                return stack[top--]; // Return the value at the top and decrement top
            }
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -999; // Return a sentinel value or throw an exception
            } else {
                return stack[top]; // Return the value at the top without removing it
            }
        }
    }

}
