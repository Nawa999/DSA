package dsa.stackqueue;

import java.util.Stack;

public class StackQueueEnqueueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // ENQUEUE operation (O(1))
    public void enqueue(int x) {
        s1.push(x);
        System.out.println("Enqueued: " + x);
    }

    // DEQUEUE operation (O(n))
    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Pop from s2 (front element)
        int dequeued = s2.pop();
        System.out.println("Dequeued: " + dequeued);

        // Move elements back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return dequeued;
    }

    // Display queue
    public void display() {
        System.out.println("Queue elements: " + s1);
    }

    // MAIN method
    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(3);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(7);
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
