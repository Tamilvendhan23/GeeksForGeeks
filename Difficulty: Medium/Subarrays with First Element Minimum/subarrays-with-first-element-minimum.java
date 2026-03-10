class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        java.util.Stack<Integer> st = new java.util.Stack<>();
        long ans = 0;  // Use long to avoid potential overflow
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            int last = st.isEmpty() ? n : st.peek();
            ans += (last - i);
            st.push(i);
        }
        return (int)ans;
    }
}
