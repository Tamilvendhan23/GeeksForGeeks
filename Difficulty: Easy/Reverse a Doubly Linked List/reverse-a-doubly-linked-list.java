/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head; // empty list or single node list
        }

        Node current = head;
        Node prevNode = null;

        while (current != null) {
            // Swap next and prev
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            // Move prevNode to current
            prevNode = current;

            // Move to next node (originally prev)
            current = current.prev;
        }

        // prevNode will be the new head
        return prevNode;
    }
}
