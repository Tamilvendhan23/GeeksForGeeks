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
    public boolean isPalindrome(Node head) {
        // Empty or single-node list is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find middle of the list (slow will reach middle)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For odd length, slow will be exactly at middle.
        // For even length, slow will be at first node of second half.

        // 2. Reverse the second half of the list starting from 'slow'
        Node secondHalfHead = reverseList(slow);

        // 3. Compare first half and reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean isPalin = true;
        while (p2 != null) {  // only need to traverse second half
            if (p1.data != p2.data) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. (Optional) Restore the list by reversing second half again
        reverseList(secondHalfHead);

        return isPalin;
    }

    // Helper to reverse a linked list in-place and return new head
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
