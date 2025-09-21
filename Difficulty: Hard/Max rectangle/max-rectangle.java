class Solution {
    static int maxArea(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            // Build histogram for current row
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1)
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int[] extended = java.util.Arrays.copyOf(heights, n + 1);

        for(int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int h = extended[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
