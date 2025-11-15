import java.util.*;

class Solution {
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] allCuts = new int[m + 2];
        System.arraycopy(cuts, 0, allCuts, 1, m);
        allCuts[0] = 0;  // start of stick
        allCuts[m + 1] = n;  // end of stick
        Arrays.sort(allCuts);

        // dp[i][j]: min cost to cut stick between allCuts[i] and allCuts[j]
        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; ++len) { // length of subproblem
            for (int i = 0; i + len < m + 2; ++i) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][m + 1];
    }
}
