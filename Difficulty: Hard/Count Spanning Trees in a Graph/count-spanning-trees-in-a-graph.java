class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n == 1) return 1;

        // Build Laplacian matrix L (n x n)
        int[][] L = new int[n][n];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            L[u][v] = -1;
            L[v][u] = -1;
            L[u][u]++;
            L[v][v]++;
        }

        // Remove last row and last column to get L'
        int[][] Lprime = new int[n - 1][n - 1];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                Lprime[i][j] = L[i][j];
            }
        }

        return det(Lprime);
    }

    // Compute determinant using cofactor expansion (for small n ≤ 9)
    private int det(int[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            int[][] minor = new int[n - 1][n - 1];
            int r1 = 0;
            for (int r = 1; r < n; r++) {
                int c1 = 0;
                for (int c = 0; c < n; c++) {
                    if (c == j) continue;
                    minor[r1][c1++] = mat[r][c];
                }
                r1++;
            }
            int sign = (j % 2 == 0) ? 1 : -1;
            res += sign * mat[0][j] * det(minor);
        }
        return res;
    }
}