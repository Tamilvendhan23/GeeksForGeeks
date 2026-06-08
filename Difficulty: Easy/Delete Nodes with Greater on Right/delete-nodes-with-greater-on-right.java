class Solution {
    
    // Reverse linked list
    Node reverse(Node head) {
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
    
    Node compute(Node head) {
        
        // Step 1: Reverse the list
        head = reverse(head);
        
        // Step 2: Keep track of max node
        int maxSoFar = head.data;
        Node curr = head;
        
        while (curr != null && curr.next != null) {
            
            // If next node is smaller than max, delete it
            if (curr.next.data < maxSoFar) {
                curr.next = curr.next.next;
            } 
            else {
                curr = curr.next;
                maxSoFar = curr.data;
            }
        }
        
        // Step 3: Reverse again to restore order
        return reverse(head);
    }
}