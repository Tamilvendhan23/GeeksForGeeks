class Solution {
    public int count(int n, int m) {
        int MOD = 1000000007;
        long[][] dp = new long[n + 1][m + 1];

        for (int x = 1; x <= m; x++) dp[1][x] = 1;

        for (int len = 2; len <= n; len++) {
            for (int cur = 1; cur <= m; cur++) {
                long ways = 0;
                for (int prev = 1; prev <= m; prev++) {
                    if (prev % cur == 0 || cur % prev == 0) {
                        ways += dp[len - 1][prev];
                    }
                }
                dp[len][cur] = ways % MOD;
            }
        }

        long ans = 0;
        for (int x = 1; x <= m; x++) ans = (ans + dp[n][x]) % MOD;
        return (int) ans;
    }
}