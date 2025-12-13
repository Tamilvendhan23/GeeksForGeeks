class Solution {
    public void swapDiagonal(int[][] mat) {
        int n = mat.length;              // matrix is n x n
        
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;           // column index on minor diagonal
            
            // swap mat[i][i] (major diagonal) with mat[i][j] (minor diagonal)
            int temp = mat[i][i];
            mat[i][i] = mat[i][j];
            mat[i][j] = temp;
        }
    }
}
