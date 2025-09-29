class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        // Calculate prefix sums
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + arr[i];
        }
        
        int maxSum = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int end = a; end <= n; ++end) {
            // Remove indices not in the window [end-b, end-a]
            while (!dq.isEmpty() && dq.peekFirst() < end - b) {
                dq.pollFirst();
            }
            // For current end, add end-a as a candidate for min prefix in window
            while (!dq.isEmpty() && pre[end - a] <= pre[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(end - a);
            // Update max sum using current window's min prefix sum
            maxSum = Math.max(maxSum, (int)(pre[end] - pre[dq.peekFirst()]));
        }
        return maxSum;
    }
}
