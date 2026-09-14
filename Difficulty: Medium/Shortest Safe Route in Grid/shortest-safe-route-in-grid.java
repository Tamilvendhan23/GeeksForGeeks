class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Helper: check if cell (r,c) is safe (1 and not adjacent to any 0)
        java.util.function.BiPredicate<Integer, Integer> isSafe = (r, c) -> {
            if (mat[r][c] != 1) return false;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 0) {
                    return false;
                }
            }
            return true;
        };

        java.util.Queue<int[]> q = new java.util.ArrayDeque<>();
        // Enqueue all safe starting cells in column 0
        for (int i = 0; i < n; i++) {
            if (isSafe.test(i, 0)) {
                q.offer(new int[]{i, 0, 1}); // row, col, distance
                mat[i][0] = -1; // mark visited
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (c == m - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && isSafe.test(nr, nc)) {
                    q.offer(new int[]{nr, nc, dist + 1});
                    mat[nr][nc] = -1; // mark visited
                }
            }
        }

        return -1; // no safe path
    }
}