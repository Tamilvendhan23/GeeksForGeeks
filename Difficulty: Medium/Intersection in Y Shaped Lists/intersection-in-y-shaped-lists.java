/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Node p1 = head1;
        Node p2 = head2;

        // Move both pointers; when one reaches end, jump to the other list's head
        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : head2;
            p2 = (p2 != null) ? p2.next : head1;
        }

        // Either the intersection node (guaranteed to exist in this problem) or null
        return p1;
    }
}
