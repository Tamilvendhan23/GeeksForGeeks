class Solution {
    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        
        // dp[i][j]: whether txt[0..i-1] matches pat[0..j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true; // empty pattern matches empty text
        
        // Initialize dp for patterns like "*", "**", "***" which can match empty txt
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char tChar = txt.charAt(i - 1);
                char pChar = pat.charAt(j - 1);
                
                if (pChar == '?' || pChar == tChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // dp[i][j-1]: '*' matches empty sequence
                    // dp[i-1][j]: '*' matches one or more characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m];
    }
}
