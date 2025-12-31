/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CircularDoublyLinkedList;

/**
 *
 * @author Admin
 */
public class CircularDoublyLinkedList {

    // Node class
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head of the list
    Node head = null;

    // Method to insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } 
        // If list is not empty
        else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Circular Doubly Linked List: ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();
    }
}

    
    

