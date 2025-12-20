package dsa.linkedlist;

public class SinglyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

   
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
    }

    
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node
    public void delete(int key) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Display list
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method 
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();

        list.insertAtBeginning(5);
        list.display();

        list.delete(20);
        list.display();
    }
}

