class Solution {
    public Node swapKth(Node head, int k) {
        // Step 1: Count the number of nodes in the list
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: If k is more than number of nodes, return head
        if (k > n) return head;

        // Step 3: If nodes are the same (from start and end), no need to swap
        if (2 * k - 1 == n) return head;

        // Step 4: Find kth node from beginning and its previous
        Node prevX = null;
        Node currX = head;
        for (int i = 1; i < k; i++) {
            prevX = currX;
            currX = currX.next;
        }

        // Step 5: Find kth node from end and its previous
        Node prevY = null;
        Node currY = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = currY;
            currY = currY.next;
        }

        // Step 6: If prevX exists, link it to currY
        if (prevX != null) prevX.next = currY;
        else head = currY;

        // Step 7: If prevY exists, link it to currX
        if (prevY != null) prevY.next = currX;
        else head = currX;

        // Step 8: Swap next pointers
        Node tempNext = currX.next;
        currX.next = currY.next;
        currY.next = tempNext;

        return head;
    }
}
