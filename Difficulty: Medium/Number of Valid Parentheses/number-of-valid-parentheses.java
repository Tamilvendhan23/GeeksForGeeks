class Solution {
    int findWays(int n) {
        if (n % 2 == 1) return 0;
        int k = n / 2;
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return (int) dp[k];
    }
}
