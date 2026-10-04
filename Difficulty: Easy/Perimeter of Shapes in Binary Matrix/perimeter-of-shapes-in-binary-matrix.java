class Solution {
    static int findPerimeter(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int perimeter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (i == 0 || mat[i - 1][j] == 0) perimeter++;
                    if (i == n - 1 || mat[i + 1][j] == 0) perimeter++;
                    if (j == 0 || mat[i][j - 1] == 0) perimeter++;
                    if (j == m - 1 || mat[i][j + 1] == 0) perimeter++;
                }
            }
        }

        return perimeter;
    }
}