/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Main function to sort the linked list using Merge Sort
    public Node mergeSort(Node head) {
        // Base case: if head is null or only one element
        if (head == null || head.next == null)
            return head;
        
        // Step 1: Split the list into two halves
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null; // Break the list

        // Step 2: Sort each half
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        // Step 3: Merge the two sorted halves
        return sortedMerge(left, right);
    }
    
    // Function to find the middle node (for splitting the list)
    private Node getMiddle(Node head) {
        if (head == null)
            return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }
    
    // Function to merge two sorted lists
    private Node sortedMerge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
}
