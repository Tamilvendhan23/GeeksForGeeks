class Solution {
    public int countBT(int h) {
        final int MOD = 1_000_000_007;

        if (h == 0) return 1;

        long[] dp = new long[h + 1];
        dp[0] = 1; // empty tree
        if (h >= 1) dp[1] = 1; // single node

        for (int i = 2; i <= h; i++) {
            long same = dp[i - 1] * dp[i - 1] % MOD;          // both subtrees height i-1
            long diff = 2L * dp[i - 1] * dp[i - 2] % MOD;     // one i-1, other i-2
            dp[i] = (same + diff) % MOD;
        }

        return (int) dp[h];
    }
}