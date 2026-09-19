class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Find the length of the Longest Common Subsequence
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];

        long cost = (long) (m - lcsLength) * costS1
                  + (long) (n - lcsLength) * costS2;

        return (int) cost;
    }
}