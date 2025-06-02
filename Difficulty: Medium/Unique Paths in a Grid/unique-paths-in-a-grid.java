class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // If starting or ending cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return 0;

        int[][] dp = new int[n][m];

        // Initialize the starting point
        dp[0][0] = 1;

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // blocked cell
                } else {
                    if (i > 0)
                        dp[i][j] += dp[i - 1][j];
                    if (j > 0)
                        dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
