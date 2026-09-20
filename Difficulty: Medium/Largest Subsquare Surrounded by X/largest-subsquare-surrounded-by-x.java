class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                    down[i][j] = 1 + (i + 1 < n ? down[i + 1][j] : 0);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxSide = Math.min(right[i][j], down[i][j]);

                for (int side = maxSide; side > answer; side--) {
                    int bottom = i + side - 1;
                    int lastColumn = j + side - 1;

                    if (right[bottom][j] >= side &&
                        down[i][lastColumn] >= side) {
                        answer = side;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}