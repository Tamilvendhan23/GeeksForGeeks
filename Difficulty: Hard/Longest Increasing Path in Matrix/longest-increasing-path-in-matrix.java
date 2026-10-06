class Solution {
    // Directions: up, down, left, right
    private static final int[][] DIRS = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) return 0;

        int[][] dp = new int[n][m]; // 0 means not computed yet
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, n, m, dp));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m, int[][] dp) {
        // If already computed, return cached result
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int best = 1; // At least the cell itself

        for (int[] d : DIRS) {
            int ni = i + d[0];
            int nj = j + d[1];

            // Check bounds
            if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                // Move only if strictly increasing
                if (matrix[ni][nj] > matrix[i][j]) {
                    best = Math.max(best, 1 + dfs(matrix, ni, nj, n, m, dp));
                }
            }
        }

        dp[i][j] = best;
        return best;
    }
}