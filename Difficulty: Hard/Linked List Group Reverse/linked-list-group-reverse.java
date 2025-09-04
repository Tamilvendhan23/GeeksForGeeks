/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head; // base cases
        
        Node curr = head;
        int count = 0;
        
        // Check if there are at least k nodes left in the list
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        if (count == k) {
            curr = head;
            Node prev = null, next = null;
            int temp = 0;
            
            // Reverse k nodes
            while (temp < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                temp++;
            }
            
            // 'head' is now the last node in the reversed group; connect it to rest
            head.next = reverseKGroup(curr, k);
            return prev;
        } else {
            // Less than k nodes left; reverse all of them
            Node prev = null;
            while (head != null) {
                Node next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
