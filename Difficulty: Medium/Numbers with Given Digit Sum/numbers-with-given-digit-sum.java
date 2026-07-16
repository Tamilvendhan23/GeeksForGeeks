class Solution {
    static final int MOD = 1000000007;

    public int countWays(int n, int sum) {
        // Maximum possible sum for n digits is 9 * n
        if (sum > 9 * n) {
            return -1;
        }

        // dp[i][s] = number of ways to choose i digits (0-9) with sum s
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1; // 0 digits, sum 0

        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                long ways = 0;
                for (int d = 0; d <= 9 && d <= s; d++) {
                    ways += dp[i - 1][s - d];
                    if (ways >= (long) MOD * 10) {
                        ways %= MOD; // avoid overflow
                    }
                }
                dp[i][s] = (int)(ways % MOD);
            }
        }

        // total ways with n digits, allowing leading zeros
        int total = dp[n][sum];

        // subtract ways where first digit is 0:
        // that is, sequences of length n whose first digit is 0
        // == length n-1 sequences (positions 2..n) with same sum
        int bad = (n >= 1) ? dp[n - 1][sum] : 0;

        int result = total - bad;
        if (result < 0) {
            result += MOD;
        }

        // If no valid n-digit number, return -1, else result
        if (result == 0) {
            return -1;
        }
        return result;
    }
}