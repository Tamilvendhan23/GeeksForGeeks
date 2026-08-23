class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // If start is obstacle or out of bounds
        if (r < 0 || c < 0 || r >= n || c >= m || mat[r][c] == '#') {
            return 0;
        }

        // visited[i][j] = 1 if cell (i,j) is reachable under constraints
        int[][] visited = new int[n][m];

        // Min-heap on (upUsed, downUsed, row, col)
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        pq.offer(new int[]{0, 0, r, c});
        visited[r][c] = 1;

        int[] dr = {-1, 1, 0, 0}; // up, down, left, right
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int upUsed = cur[0];
            int downUsed = cur[1];
            int row = cur[2];
            int col = cur[3];

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                // Bounds check
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                // Obstacle check
                if (mat[nr][nc] == '#') continue;
                // Already visited
                if (visited[nr][nc] == 1) continue;

                int newUp = upUsed;
                int newDown = downUsed;

                if (k == 0) { // up
                    newUp = upUsed + 1;
                    if (newUp > u) continue;
                } else if (k == 1) { // down
                    newDown = downUsed + 1;
                    if (newDown > d) continue;
                }
                // left/right: no change in up/down counts

                visited[nr][nc] = 1;
                pq.offer(new int[]{newUp, newDown, nr, nc});
            }
        }

        // Count visited cells
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1) count++;
            }
        }
        return count;
    }
}