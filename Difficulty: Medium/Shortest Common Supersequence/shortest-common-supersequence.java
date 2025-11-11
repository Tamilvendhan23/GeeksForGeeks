class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // dp[i][j] will store length of LCS of s1[0..i-1], s2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        
        // Build the dp table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // SCS length = sum of lengths - LCS length
        return n + m - dp[n][m];
    }
}
