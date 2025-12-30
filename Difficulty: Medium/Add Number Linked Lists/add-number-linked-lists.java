class Solution {

    // Reverse a linked list
    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addTwoLists(Node head1, Node head2) {

        // Step 1: reverse both lists
        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;
        Node dummy = new Node(0);
        Node tail = dummy;

        // Step 2: add digits
        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;
        }

        // Step 3: reverse result back
        Node result = reverse(dummy.next);

        // Step 4: remove leading zeros (if any)
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }
}
