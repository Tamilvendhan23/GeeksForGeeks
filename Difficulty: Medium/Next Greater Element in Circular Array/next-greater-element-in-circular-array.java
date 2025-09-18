import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            
            // Maintain decreasing stack
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[idx]) {
                stack.pop();
            }
            
            // Only fill answers in the first pass
            if (i < n && !stack.isEmpty()) {
                res.set(idx, arr[stack.peek()]);
            }
            
            stack.push(idx);
        }
        
        return res;
    }
}
