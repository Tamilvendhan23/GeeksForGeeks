class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        int n = mat.length;
        int m = mat[0].length;

        // If source or destination is blocked, no valid path
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        int[] ans = new int[]{-1}; // global max length holder

        dfs(xs, ys, mat, visited, xd, yd, 0, ans, n, m);
        return ans[0];
    }

    private void dfs(int x, int y,
                     int[][] mat,
                     boolean[][] visited,
                     int xd, int yd,
                     int len,
                     int[] ans,
                     int n, int m) {

        // Out of bounds or blocked or already visited
        if (x < 0 || x >= n || y < 0 || y >= m ||
            mat[x][y] == 0 || visited[x][y]) {
            return;
        }

        // If destination reached, update longest path
        if (x == xd && y == yd) {
            ans[0] = Math.max(ans[0], len);
            return;
        }

        visited[x][y] = true;

        // 4 possible moves: up, down, left, right
        dfs(x - 1, y, mat, visited, xd, yd, len + 1, ans, n, m); // up
        dfs(x + 1, y, mat, visited, xd, yd, len + 1, ans, n, m); // down
        dfs(x, y - 1, mat, visited, xd, yd, len + 1, ans, n, m); // left
        dfs(x, y + 1, mat, visited, xd, yd, len + 1, ans, n, m); // right

        // backtrack: unmark current cell
        visited[x][y] = false;
    }
}