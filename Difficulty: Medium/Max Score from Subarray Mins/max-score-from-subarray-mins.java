import java.util.*;

class Solution {
    public int maxSum(int[] arr) {
        int n = arr.length;
        int maxScore = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    int second = stack.peek();
                    maxScore = Math.max(maxScore, arr[top] + arr[second]);
                }
                maxScore = Math.max(maxScore, arr[top] + arr[i]);
            }
            stack.push(i);
        }

        // For remaining stack elements
        while (stack.size() >= 2) {
            int first = stack.pop();
            int second = stack.peek();
            maxScore = Math.max(maxScore, arr[first] + arr[second]);
        }

        return maxScore;
    }
}
