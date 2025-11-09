class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        if (mat[0][0] == -1 || mat[n-1][n-1] == -1) return 0;

        int[][][] dp = new int[2*n-1][n][n];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = mat[0][0];

        for (int k = 1; k < 2*n-1; k++) {
            for (int r1 = 0; r1 < n; r1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    int c1 = k - r1;
                    int c2 = k - r2;
                    if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) continue;
                    if (mat[r1][c1] == -1 || mat[r2][c2] == -1) continue;

                    int chocolates = (r1 == r2) ? mat[r1][c1] : mat[r1][c1] + mat[r2][c2];

                    int prev = Integer.MIN_VALUE;
                    if (r1 > 0 && r2 > 0) prev = Math.max(prev, dp[k-1][r1-1][r2-1]);
                    if (r1 > 0 && c2 > 0) prev = Math.max(prev, dp[k-1][r1-1][r2]);
                    if (c1 > 0 && r2 > 0) prev = Math.max(prev, dp[k-1][r1][r2-1]);
                    if (c1 > 0 && c2 > 0) prev = Math.max(prev, dp[k-1][r1][r2]);

                    if (prev != Integer.MIN_VALUE) {
                        dp[k][r1][r2] = prev + chocolates;
                    }
                }
            }
        }

        return Math.max(dp[2*n-2][n-1][n-1], 0);
    }
}
