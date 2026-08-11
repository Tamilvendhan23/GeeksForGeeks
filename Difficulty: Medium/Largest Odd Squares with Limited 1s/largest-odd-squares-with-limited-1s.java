import java.util.*;

class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // pref[i][j] = number of 1s in rectangle
        // rows [0, i-1] and columns [0, j-1]
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j]
                        + pref[i][j + 1]
                        + pref[i + 1][j]
                        - pref[i][j];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int r = query[0];
            int c = query[1];

            // Maximum possible expansion radius
            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            int low = 0;
            int high = maxRadius;
            int bestRadius = -1;

            while (low <= high) {
                int radius = low + (high - low) / 2;

                int top = r - radius;
                int bottom = r + radius;
                int left = c - radius;
                int right = c + radius;

                int ones = getSum(pref, top, left, bottom, right);

                if (ones <= k) {
                    bestRadius = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            // If even the 1 x 1 square has more than k ones,
            // no valid square exists.
            result.add(bestRadius == -1 ? -1 : 2 * bestRadius + 1);
        }

        return result;
    }

    private int getSum(int[][] pref, int top, int left,
                       int bottom, int right) {
        return pref[bottom + 1][right + 1]
                - pref[top][right + 1]
                - pref[bottom + 1][left]
                + pref[top][left];
    }
}