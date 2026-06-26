class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int mod = 1000000007;

        if (m > n) return 0;

        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = m; j >= 1; j--) {
                if (c1 == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
                }
            }
        }

        return (int) dp[m];
    }
}