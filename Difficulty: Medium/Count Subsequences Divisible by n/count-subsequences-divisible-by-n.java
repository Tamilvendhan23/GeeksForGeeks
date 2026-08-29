class Solution {
    public int countSubsequences(String s, int n) {
        long MOD = 1_000_000_007L;
        int len = s.length();

        long[] dp = new long[n]; // dp[r] = count of subsequences with remainder r

        for (int i = 0; i < len; i++) {
            int d = s.charAt(i) - '0';

            long[] next = new long[n];

            // Extend existing subsequences by appending digit d
            for (int r = 0; r < n; r++) {
                if (dp[r] == 0) continue;
                int nr = (int)((1L * r * 10 + d) % n);
                next[nr] = (next[nr] + dp[r]) % MOD;
            }

            // Start a new subsequence from this digit alone
            int startRem = d % n;
            next[startRem] = (next[startRem] + 1) % MOD;

            // Merge next into dp
            for (int r = 0; r < n; r++) {
                dp[r] = (dp[r] + next[r]) % MOD;
            }
        }

        return (int)dp[0];
    }
}