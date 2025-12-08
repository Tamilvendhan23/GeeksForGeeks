class Solution {
    public String matrixChainOrder(int arr[]) {
        int n = arr.length;          // arr size = number of dims = matrices + 1
        int m = n - 1;               // number of matrices

        // dp[i][j] = min cost of multiplying matrices i..j (1-based indices)
        int[][] dp = new int[m + 1][m + 1];
        int[][] brk = new int[m + 1][m + 1]; // stores split index

        // length = chain length
        for (int len = 2; len <= m; len++) {
            for (int i = 1; i <= m - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j]; // dims
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        brk[i][j] = k;
                    }
                }
            }
        }

        // build parenthesization from 1..m
        return buildOrder(1, m, brk);
    }

    private String buildOrder(int i, int j, int[][] brk) {
        if (i == j) {
            // matrix letters A, B, C, ...
            return String.valueOf((char) ('A' + i - 1));
        }
        int k = brk[i][j];
        String left = buildOrder(i, k, brk);
        String right = buildOrder(k + 1, j, brk);
        return "(" + left + right + ")";
    }
}
