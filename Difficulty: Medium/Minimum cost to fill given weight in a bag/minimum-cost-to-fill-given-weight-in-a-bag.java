class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int INF = Integer.MAX_VALUE;
        
        // dp[i] = minimum cost to get exactly weight i
        int[] dp = new int[w + 1];
        
        // Initialize dp array with INF
        for (int i = 0; i <= w; i++) {
            dp[i] = INF;
        }
        
        // Base case: cost to get 0 kg is 0
        dp[0] = 0;
        
        // Build dp table in bottom-up manner
        for (int i = 1; i <= w; i++) {
            // Try all packet types for weight i
            for (int j = 0; j < n; j++) {
                // cost[j] = -1 means packet is unavailable
                // j+1 is the weight of packet at index j
                if (cost[j] != -1 && (j + 1) <= i && dp[i - (j + 1)] != INF) {
                    dp[i] = Math.min(dp[i], cost[j] + dp[i - (j + 1)]);
                }
            }
        }
        
        // If dp[w] is still INF, we can't make exactly w kg
        return (dp[w] == INF) ? -1 : dp[w];
    }
}