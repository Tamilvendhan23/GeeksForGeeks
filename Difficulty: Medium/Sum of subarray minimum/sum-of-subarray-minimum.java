import java.util.*;

class Solution {
    public int sumSubMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;

        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Less Element (PLE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less Element (NLE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            result = (result + (arr[i] * left * right) % MOD) % MOD;
        }

        return (int) result;
    }
}
