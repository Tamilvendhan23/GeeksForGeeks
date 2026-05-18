class Solution {
    public int maxSum(int n) {
        // Base case: for n = 0 or 1, the maximum sum is n itself
        if (n == 0 || n == 1) {
            return n;
        }
        
        // Create a memoization array to store computed results
        int[] dp = new int[n + 1];
        
        return solve(n, dp);
    }
    
    private int solve(int n, int[] dp) {
        // Base case
        if (n == 0 || n == 1) {
            return n;
        }
        
        // If already computed, return the stored value
        if (dp[n] != 0) {
            return dp[n];
        }
        
        // Recursively break into n/2, n/3, n/4 and take max of:
        // 1. The current value n itself
        // 2. The sum of maximum sums of the three parts
        dp[n] = Math.max(solve(n / 2, dp) + solve(n / 3, dp) + solve(n / 4, dp), n);
        
        return dp[n];
    }
}