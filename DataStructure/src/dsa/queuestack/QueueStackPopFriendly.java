package dsa.queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // PUSH operation (O(n))
    public void push(int x) {
        // Step 1: Move all elements to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 2: Add new element to q1
        q1.add(x);
        System.out.println("Pushed: " + x);

        // Step 3: Move elements back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // POP operation (O(1))
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int popped = q1.remove();
        System.out.println("Popped: " + popped);
        return popped;
    }

    // DISPLAY stack
    public void display() {
        System.out.println("Stack elements: " + q1);
    }

    // MAIN method
    public static void main(String[] args) {

        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.pop();
        stack.push(9);
        stack.display();
    }
}
