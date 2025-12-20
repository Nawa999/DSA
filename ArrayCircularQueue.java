package dsa.queue;

public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public ArrayCircularQueue(int capacity) {
        size = capacity;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    public void enqueue(int value) {

        // Queue full condition
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
            return;
        }

        //  insertion
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;
        System.out.println("Enqueued: " + value);
    }

    // Dequeue op
    public int dequeue() {

        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = queue[front];

      
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Display queue elements
    public void display() {

        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");
        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        ArrayCircularQueue cq = new ArrayCircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        cq.display();

        cq.dequeue();
        cq.dequeue();

        cq.display();

        cq.enqueue(50);
        cq.enqueue(60);

        cq.display();
    }
}
