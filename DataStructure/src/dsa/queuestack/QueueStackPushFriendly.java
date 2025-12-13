package dsa.queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // PUSH operation (O(1))
    public void push(int x) {
        q1.add(x);
        System.out.println("Pushed: " + x);
    }

    // POP operation (O(n))
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Move elements except last
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println("Popped: " + popped);
        return popped;
    }

    // DISPLAY stack
    public void display() {
        System.out.println("Stack elements: " + q1);
    }

    // MAIN method
    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.pop();
        stack.push(9);
        stack.display();
    }
}
