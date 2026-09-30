class Solution {
    public int ways(int x, int y) {
        final int MOD = 1_000_000_007;

        // Number of paths = C(x + y, x)
        long[][] dp = new long[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= y; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return (int) dp[x][y];
    }
}