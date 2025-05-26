/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        // Case 1: If the list is empty
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        // Case 2: Insert before head (or at end of list if all values are smaller)
        if (data <= head.data) {
            // Find the last node to maintain circular property
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            return newNode; // new node becomes the new head
        }

        // Case 3: Insert in the middle or end
        while (current.next != head && current.next.data < data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head; // head remains the same
    }
}
