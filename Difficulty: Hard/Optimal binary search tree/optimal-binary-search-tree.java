class Solution {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;
        if (n == 0) return 0;

        // dp[i][j] = min cost of BST using keys[i..j]
        int[][] dp = new int[n][n];

        // prefix sums for freq to get range sums in O(1)
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + freq[i];
        }

        // cost of single key is its frequency
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }

        // len = length of interval
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                // sum of freq[i..j]
                int fsum = prefix[j + 1] - prefix[i];

                int best = Integer.MAX_VALUE;

                // try each key in [i..j] as root
                for (int r = i; r <= j; r++) {
                    int left  = (r > i) ? dp[i][r - 1] : 0;
                    int right = (r < j) ? dp[r + 1][j] : 0;
                    int cost = left + right + fsum;
                    if (cost < best) best = cost;
                }

                dp[i][j] = best;
            }
        }

        return dp[0][n - 1];
    }
}
