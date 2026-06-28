class Solution {
    public int countStrings(int n, int k) {
        int MOD = 1000000007;

        if (k > n - 1) return 0;

        long[][][] dp = new long[n + 1][k + 1][2];

        // Length 1
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                // End with 0
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                // End with 1 after 0
                dp[i][j][1] = dp[i - 1][j][0];

                // End with 1 after 1 (creates one more adjacent pair)
                if (j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % MOD;
                }
            }
        }

        return (int)((dp[n][k][0] + dp[n][k][1]) % MOD);
    }
}