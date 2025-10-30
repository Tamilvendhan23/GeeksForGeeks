class Solution {
    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Mark boundary 'O's and their connected 'O's
        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0, n, m);
            dfs(grid, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            dfs(grid, 0, j, n, m);
            dfs(grid, n - 1, j, n, m);
        }
        
        // Step 2: Replace surrounded 'O's with 'X', revert marked to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                else if (grid[i][j] == '#')
                    grid[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 'O')
            return;
        grid[i][j] = '#';
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }
}
