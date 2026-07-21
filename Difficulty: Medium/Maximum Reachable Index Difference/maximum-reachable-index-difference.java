class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] bestEnd = new int[26];
        int[] dp = new int[n];

        for (int i = 0; i < 26; i++) bestEnd[i] = -1;

        int ans = -1;
        boolean hasA = false;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';

            if (ch == 25 || bestEnd[ch + 1] == -1)
                dp[i] = i;
            else
                dp[i] = bestEnd[ch + 1];

            bestEnd[ch] = Math.max(bestEnd[ch], dp[i]);

            if (ch == 0) {
                hasA = true;
                ans = Math.max(ans, dp[i] - i);
            }
        }

        return hasA ? ans : -1;
    }
}