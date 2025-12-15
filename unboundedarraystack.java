package dsa.stack;

public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public UnboundedArrayStack() {
        capacity = 2;              // initial size
        stack = new int[capacity];
        top = -1;
    }

    // PUSH operation (dynamic grow)
    public void push(int value) {
        if (top == capacity - 1) {
            resize(capacity * 2);  // double size
        }
        stack[++top] = value;
        System.out.println("Pushed: " + value + " | Capacity: " + capacity);
    }

    // POP operation (dynamic shrink)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int popped = stack[top--];

        // shrink when stack is 1/4 full
        if (top + 1 > 0 && top + 1 <= capacity / 4) {
            resize(capacity / 2);
        }

        System.out.println("Popped: " + popped + " | Capacity: " + capacity);
        return popped;
    }

    // Resize stack
    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    // Check empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Display stack
    public void display() {
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();
    }
}
