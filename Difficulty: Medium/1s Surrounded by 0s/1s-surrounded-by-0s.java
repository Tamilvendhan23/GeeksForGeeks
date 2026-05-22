class Solution {
    // directions for 4‑way moves
    private int[] dr = {1, 0, -1, 0};
    private int[] dc = {0, 1, 0, -1};

    // DFS to remove all 1s connected to boundary
    private void dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int ni = i + dr[k];
            int nj = j + dc[k];
            dfs(ni, nj, grid);
        }
    }

    // MAIN FUNCTION
    public int cntOnes(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;

        // Step 1: remove all 1s connected to boundary
        // first and last columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid);
            }
        }
        // first and last rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid);
            }
            if (grid[n - 1][j] == 1) {
                dfs(n - 1, j, grid);
            }
        }

        // Step 2: count remaining 1s (they are enclosed)
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }
}