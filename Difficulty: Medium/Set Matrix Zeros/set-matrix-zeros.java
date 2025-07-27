class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // 1. Check if first row, first column need to be zeroed
        for (int i = 0; i < n; i++)
            if (mat[i][0] == 0) firstColZero = true;
        for (int j = 0; j < m; j++)
            if (mat[0][j] == 0) firstRowZero = true;

        // 2. Use first row and column to mark zero rows and columns
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }

        // 3. Zero cells based on first row and column markers
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;

        // 4. Zero first row if needed
        if (firstRowZero)
            for (int j = 0; j < m; j++)
                mat[0][j] = 0;

        // 5. Zero first column if needed
        if (firstColZero)
            for (int i = 0; i < n; i++)
                mat[i][0] = 0;
    }
}
