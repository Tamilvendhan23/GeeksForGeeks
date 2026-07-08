class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int countCoordinates(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        // Station P (Top + Left)
        for (int i = 0; i < n; i++)
            dfs(mat, p, i, 0);

        for (int j = 0; j < m; j++)
            dfs(mat, p, 0, j);

        // Station Q (Bottom + Right)
        for (int i = 0; i < n; i++)
            dfs(mat, q, i, m - 1);

        for (int j = 0; j < m; j++)
            dfs(mat, q, n - 1, j);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j])
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int[][] mat, boolean[][] vis, int x, int y) {
        if (vis[x][y])
            return;

        vis[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !vis[nx][ny]
                    && mat[nx][ny] >= mat[x][y]) {
                dfs(mat, vis, nx, ny);
            }
        }
    }
}