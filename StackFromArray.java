public class StackFromArray {
    int[] mystack;
    int top;
    int capacity;
    public StackFromArray(int size) {
        mystack = new int[size];
        capacity = size;
        top = -1; // Stack is initially empty
    }
    public boolean isEmpty(){
        return top==-1;// Stack is empty when top is at -1
    }
    public boolean isFull(){
        return top==capacity-1;// Stack is full when top is at the last index
    }
    public void push (int value){
        if(isFull()){
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            top++; // Increment top to point to the next empty position
            mystack[top] = value; // Add the value to the stack
            System.out.println("Pushed " + value + " onto the stack.");
        }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack overflow");
            return -9999; // Return a sentinel value or throw an exception
        }else{
            int value = mystack[top]; // Get the value at the top of the stack
            top--; // Decrement top to remove the value from the stack
            return value;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty. Cannot peek.");
            return -999; // Return a sentinel value or throw an exception
        } else {
            int value =mystack[top]; // Get the value at the top of the stack without removing it
            return value;
        }
    }
    public int size() {
        return top + 1; // Return the number of elements in the stack
    }
    class UsingStackFromArray {
        public static void main(String[] args) {
            StackFromArray stack = new StackFromArray(5); // Create a stack of size 5
            stack.push(10); // Push 10 onto the stack
            stack.push(20); // Push 20 onto the stack
            System.out.println("Top element: " + stack.peek()); // Peek at the top element (20)
            System.out.println("Popped element: " + stack.pop()); // Pop the top element (20)
            System.out.println("Is stack empty? " + stack.isEmpty()); // Check if the stack is empty
            System.out.println(stack);
            System.out.println("Current stack size: " + stack.size()); // Get the current size of the stack

        }
    }
}

