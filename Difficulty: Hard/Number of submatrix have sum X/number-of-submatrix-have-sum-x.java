class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        int[][] prefix = new int[n][m];
        
        // Build row prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i][0] = mat[i][0];
            for (int j = 1; j < m; j++) {
                prefix[i][j] = prefix[i][j - 1] + mat[i][j];
            }
        }
        
        int count = 0;
        int maxK = Math.min(n, m);
        
        for (int k = 1; k <= maxK; k++) {
            for (int left = 0; left <= m - k; left++) {
                int right = left + k - 1;
                long sum = 0;
                
                // Initial sum for first k-1 rows
                for (int row = 0; row < k - 1; row++) {
                    sum += prefix[row][right] - (left > 0 ? prefix[row][left - 1] : 0);
                }
                
                // Slide window vertically
                for (int top = k - 1; top < n; top++) {
                    // Add current row
                    sum += prefix[top][right] - (left > 0 ? prefix[top][left - 1] : 0);
                    
                    if (sum == x) count++;
                    
                    // Subtract outgoing row (if not first window)
                    if (top - k + 1 >= 0) {
                        sum -= prefix[top - k + 1][right] - (left > 0 ? prefix[top - k + 1][left - 1] : 0);
                    }
                }
            }
        }
        return count;
    }
}
