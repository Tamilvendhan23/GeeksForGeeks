class Solution {
    public int minCost(int n, int i, int d, int c) {
        // dp[k] = min cost to get exactly k characters
        int[] dp = new int[n + 1];

        // Initialize with a large value
        final int INF = Integer.MAX_VALUE / 2;
        for (int k = 1; k <= n; k++) {
            dp[k] = INF;
        }
        dp[0] = 0;

        for (int k = 1; k <= n; k++) {
            // Option 1: insert one character from k-1
            dp[k] = Math.min(dp[k], dp[k - 1] + i);

            if (k % 2 == 0) {
                // Option 2: k is even, copy-paste from k/2
                int fromHalf = dp[k / 2] + c;
                dp[k] = Math.min(dp[k], fromHalf);
            } else {
                // Option 3: k is odd, copy-paste from (k+1)/2 to get k+1, then delete 1
                int fromHalfPlusOne = dp[(k + 1) / 2] + c + d;
                dp[k] = Math.min(dp[k], fromHalfPlusOne);
            }
        }

        return dp[n];
    }
}