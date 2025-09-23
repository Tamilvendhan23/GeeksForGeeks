import java.util.*;

class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // base case: if queue is empty, return
        if (q.isEmpty()) {
            return;
        }

        // step 1: remove front element
        int front = q.poll();

        // step 2: recursively reverse remaining queue
        reverseQueue(q);

        // step 3: add removed element at the end
        q.add(front);
    }

    // just for testing
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(10);
        q.add(15);
        q.add(20);
        q.add(25);

        Solution sol = new Solution();
        sol.reverseQueue(q);

        System.out.println(q); // Output: [25, 20, 15, 10, 5]
    }
}
