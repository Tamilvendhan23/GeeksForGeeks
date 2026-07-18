import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int findWays(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] suf = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                suf[i][j] = matrix[i][j]
                        + suf[i + 1][j]
                        + suf[i][j + 1]
                        - suf[i + 1][j + 1];
            }
        }

        int[][][] dp = new int[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (suf[i][j] > 0)
                    dp[1][i][j] = 1;
            }
        }

        for (int p = 2; p <= k; p++) {

            int[][] sufRow = new int[n + 1][m];

            for (int c = 0; c < m; c++) {
                for (int r = n - 1; r >= 0; r--) {
                    sufRow[r][c] = (dp[p - 1][r][c] + sufRow[r + 1][c]) % MOD;
                }
            }

            int[][] sufCol = new int[n][m + 1];

            for (int r = 0; r < n; r++) {
                for (int c = m - 1; c >= 0; c--) {
                    sufCol[r][c] = (dp[p - 1][r][c] + sufCol[r][c + 1]) % MOD;
                }
            }

            for (int r = n - 1; r >= 0; r--) {
                for (int c = m - 1; c >= 0; c--) {

                    if (suf[r][c] == 0)
                        continue;

                    int ans = 0;

                    int lo = r + 1, hi = n;

                    while (lo < hi) {
                        int mid = (lo + hi) / 2;

                        if (suf[mid][c] < suf[r][c])
                            hi = mid;
                        else
                            lo = mid + 1;
                    }

                    if (lo < n)
                        ans = (ans + sufRow[lo][c]) % MOD;

                    lo = c + 1;
                    hi = m;

                    while (lo < hi) {
                        int mid = (lo + hi) / 2;

                        if (suf[r][mid] < suf[r][c])
                            hi = mid;
                        else
                            lo = mid + 1;
                    }

                    if (lo < m)
                        ans = (ans + sufCol[r][lo]) % MOD;

                    dp[p][r][c] = ans;
                }
            }
        }

        return dp[k][0][0];
    }
}