class Solution {
    static class Cell implements Comparable<Cell> {
        int x, y, effort;
        Cell(int x, int y, int effort) {
            this.x = x; this.y = y; this.effort = effort;
        }
        public int compareTo(Cell other) { return this.effort - other.effort; }
    }
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) java.util.Arrays.fill(row, Integer.MAX_VALUE);
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        java.util.PriorityQueue<Cell> pq = new java.util.PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Cell(0, 0, 0));
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int x = curr.x, y = curr.y, effort = curr.effort;
            if (x == n - 1 && y == m - 1) return effort;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nextEffort = Math.max(effort, Math.abs(mat[x][y] - mat[nx][ny]));
                    if (nextEffort < dist[nx][ny]) {
                        dist[nx][ny] = nextEffort;
                        pq.add(new Cell(nx, ny, nextEffort));
                    }
                }
            }
        }
        return -1;
    }
}
