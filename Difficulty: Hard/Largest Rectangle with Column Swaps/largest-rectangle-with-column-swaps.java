class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] heights = new int[m];
        int maxArea = 0;
        int[] sorted = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            System.arraycopy(heights, 0, sorted, 0, m);
            java.util.Arrays.sort(sorted);

            for (int k = 1; k <= m; k++) {
                int height = sorted[m - k];
                int area = height * k;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}