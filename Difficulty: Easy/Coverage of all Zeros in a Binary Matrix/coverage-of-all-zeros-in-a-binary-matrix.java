class Solution {
    public int findCoverage(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int res = 0;
        
        // Traverse rows: left to right (check for 1's on the left)
        for (int i = 0; i < r; i++) {
            boolean isOne = false;
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    isOne = true;
                } else if (isOne) {
                    res++;
                }
            }
        }
        
        // Traverse rows: right to left (check for 1's on the right)
        for (int i = 0; i < r; i++) {
            boolean isOne = false;
            for (int j = c - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    isOne = true;
                } else if (isOne) {
                    res++;
                }
            }
        }
        
        // Traverse columns: top to bottom (check for 1's above)
        for (int j = 0; j < c; j++) {
            boolean isOne = false;
            for (int i = 0; i < r; i++) {
                if (mat[i][j] == 1) {
                    isOne = true;
                } else if (isOne) {
                    res++;
                }
            }
        }
        
        // Traverse columns: bottom to top (check for 1's below)
        for (int j = 0; j < c; j++) {
            boolean isOne = false;
            for (int i = r - 1; i >= 0; i--) {
                if (mat[i][j] == 1) {
                    isOne = true;
                } else if (isOne) {
                    res++;
                }
            }
        }
        
        return res;
    }
}