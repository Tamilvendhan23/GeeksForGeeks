class Solution {
    public int minimumSum(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int k = (n + 1) / 2;          // number of palindrome "slots"
        int[] fixed = new int[k];      // -1 = free, otherwise required char
        java.util.Arrays.fill(fixed, -1);

        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            char a = c[i], b = c[j];

            if (a != '?' && b != '?') {
                if (a != b) return -1;
                fixed[i] = a - 'a';
            } else if (a != '?') {
                fixed[i] = a - 'a';
            } else if (b != '?') {
                fixed[i] = b - 'a';
            }
        }

        if ((n & 1) == 1) {
            char mid = c[n / 2];
            if (mid != '?') fixed[n / 2] = mid - 'a';
        }

        final int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[k][26];

        for (int ch = 0; ch < 26; ch++) {
            dp[0][ch] = (fixed[0] == -1 || fixed[0] == ch) ? 0 : INF;
        }

        for (int i = 1; i < k; i++) {
            for (int ch = 0; ch < 26; ch++) {
                if (fixed[i] != -1 && fixed[i] != ch) {
                    dp[i][ch] = INF;
                    continue;
                }

                int best = INF;
                for (int prev = 0; prev < 26; prev++) {
                    if (dp[i - 1][prev] == INF) continue;
                    int cost = dp[i - 1][prev] + 2 * Math.abs(prev - ch);
                    best = Math.min(best, cost);
                }
                dp[i][ch] = best;
            }
        }

        int ans = INF;
        for (int ch = 0; ch < 26; ch++) {
            ans = Math.min(ans, dp[k - 1][ch]);
        }

        return ans;
    }
}