class Solution {
    public int optimalKeys(int n) {
        // For small n, pressing 'A' every time is optimal
        if (n <= 6) return n;

        int[] dp = new int[n + 1];

        // Base cases
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        // Compute maximum A's for each keystroke count
        for (int i = 7; i <= n; i++) {
            dp[i] = 0;

            // Try all possible breakpoints
            // j = point where we do Ctrl+A, Ctrl+C
            for (int j = i - 3; j >= 1; j--) {
                int curr = dp[j] * (i - j - 1);
                dp[i] = Math.max(dp[i], curr);
            }
        }

        return dp[n];
    }
}