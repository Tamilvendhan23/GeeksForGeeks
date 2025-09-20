import java.util.Stack;

class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;

        int[] nextGreater = new int[n];
        for (int i = 0; i < n; i++) nextGreater[i] = n;
        int[] prevGreater = new int[n];
        for (int i = 0; i < n; i++) prevGreater[i] = -1;

        Stack<Integer> st = new Stack<>();

        // Find Next Greater Element to the Right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }

        // Clear stack for next pass
        st.clear();

        // Find Next Greater Element to the Left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        // Find the maximum valid subarray length
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (windowSize >= arr[i]) {
                maxLength = Math.max(maxLength, windowSize);
            }
        }
        return maxLength;
    }
}
