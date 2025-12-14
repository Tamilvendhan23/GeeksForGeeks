import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D prefix sum matrix
        int[][] pref = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = mat[i][j];

                if (i > 0) {
                    val += pref[i - 1][j];
                }
                if (j > 0) {
                    val += pref[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    val -= pref[i - 1][j - 1];
                }

                pref[i][j] = val;
            }
        }

        // Answer each query
        ArrayList<Integer> ans = new ArrayList<>();

        for (int k = 0; k < queries.length; k++) {
            int r1 = queries[k][0];
            int c1 = queries[k][1];
            int r2 = queries[k][2];
            int c2 = queries[k][3];

            int total = pref[r2][c2];
            int top = (r1 > 0) ? pref[r1 - 1][c2] : 0;
            int left = (c1 > 0) ? pref[r2][c1 - 1] : 0;
            int overlap = (r1 > 0 && c1 > 0) ? pref[r1 - 1][c1 - 1] : 0;

            int sum = total - top - left + overlap;
            ans.add(sum);
        }

        return ans;
    }
}
