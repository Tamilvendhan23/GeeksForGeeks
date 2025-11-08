class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        // dp[i][j][s]: number of ways to reach (i, j) with s coins
        int[][][] dp = new int[n][m][k + 1];
        
        // Base case: for the top-left cell
        if (mat[0][0] <= k)
            dp[0][0][mat[0][0]] = 1;

        // Fill the DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int s = 0; s <= k; s++) {
                    if (dp[i][j][s] > 0 || (i == 0 && j == 0 && s == mat[0][0])) { // only proceed if this cell is reachable
                        if (i + 1 < n && s + mat[i + 1][j] <= k)
                            dp[i + 1][j][s + mat[i + 1][j]] += dp[i][j][s];
                        if (j + 1 < m && s + mat[i][j + 1] <= k)
                            dp[i][j + 1][s + mat[i][j + 1]] += dp[i][j][s];
                    }
                }
            }
        }
        return dp[n - 1][m - 1][k];
    }
}
