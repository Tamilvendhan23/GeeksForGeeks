import java.util.*;

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Calculate frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int currFreq = freq.get(arr[i]);

            // Pop elements from stack with freq <= currFreq
            while (!stack.isEmpty() && freq.get(stack.peek()) <= currFreq) {
                stack.pop();
            }

            // If stack is not empty, top is the next greater freq element
            if (!stack.isEmpty()) {
                res.set(i, stack.peek());
            }

            // Push current element
            stack.push(arr[i]);
        }

        return res;
    }
}