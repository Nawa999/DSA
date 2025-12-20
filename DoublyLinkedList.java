package dsa.linkedlist;

public class DoublyLinkedList {

   
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;

    // Insert 
    public void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
    }

    // Delete
    public void delete(int key) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            // deleting head
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Main method 
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.displayForward();
        list.displayBackward();

        list.insertAtBeginning(5);
        list.displayForward();

        list.delete(20);
        list.displayForward();
        list.displayBackward();
    }
}
