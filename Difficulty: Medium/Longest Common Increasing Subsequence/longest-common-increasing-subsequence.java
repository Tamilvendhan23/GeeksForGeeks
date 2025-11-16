class Solution {
    public int LCIS(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int best = 0;  // best dp[j] for b[j] < a[i]
            for (int j = 0; j < m; j++) {
                if (a[i] > b[j]) {
                    best = Math.max(best, dp[j]);
                } else if (a[i] == b[j]) {
                    dp[j] = best + 1;
                    ans = Math.max(ans, dp[j]);
                }
                // If a[i] < b[j], do nothing.
            }
        }
        return ans;
    }
}
