class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        java.util.Arrays.fill(prev, -1);
        java.util.Stack<Integer> st = new java.util.Stack<>();
        
        // Compute previous strictly greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                prev[i] = st.peek();
            }
            st.push(i);
        }
        
        int[] next = new int[n];
        java.util.Arrays.fill(next, n);
        st = new java.util.Stack<>();
        
        // Compute next strictly greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                next[i] = st.peek();
            }
            st.push(i);
        }
        
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            int leftBound = (prev[i] == -1 ? 0 : prev[i] + 1);
            int rightBound = (next[i] == n ? n - 1 : next[i] - 1);
            int count = rightBound - leftBound + 1;
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}
