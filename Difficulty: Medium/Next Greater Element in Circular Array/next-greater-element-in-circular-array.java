import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int current = arr[i % n];

            // Compare with elements in stack
            while (!stack.isEmpty() && arr[stack.peek()] < current) {
                int index = stack.pop();
                result.set(index, current);
            }

            // Push index only in first loop
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
