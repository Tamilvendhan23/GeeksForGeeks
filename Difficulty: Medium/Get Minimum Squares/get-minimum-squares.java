class Solution {
    public int minSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; // Base case: 0 needs 0 squares
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Maximum is i (1*1 used i times)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}

