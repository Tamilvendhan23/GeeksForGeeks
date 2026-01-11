class Solution {
    public String minWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if (n > m) return "";
        
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill DP table: dp[i][j] = starting index (1-based) in s1 for s2[0..j-1] ending at s1[0..i-1]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    if (j == 1) {
                        dp[i][j] = i;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // Find minimum window
        int startIndex = 0;
        int minLength = m + 1;
        
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s2.charAt(n - 1) && dp[i][n] > 0) {
                int windowStart = dp[i][n] - 1;  // Convert to 0-based
                int windowLength = i - windowStart;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = windowStart;
                }
            }
        }
        
        return minLength > m ? "" : s1.substring(startIndex, startIndex + minLength);
    }
}
