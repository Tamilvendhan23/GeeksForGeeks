/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

import java.util.PriorityQueue;

class Solution {
    Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each list to the priority queue
        for (Node node : arr) {
            if (node != null) {
                pq.add(node);
            }
        }

        Node dummy = new Node(0); // Dummy head
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) {
                pq.add(curr.next); // Push next node from this list
            }
        }

        return dummy.next; // Head of merged list
    }
}
