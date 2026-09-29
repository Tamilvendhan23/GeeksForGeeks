import java.util.*;

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int startRow = knightPos[0] - 1;
        int startCol = knightPos[1] - 1;

        int targetRow = targetPos[0] - 1;
        int targetCol = targetPos[1] - 1;

        if (startRow == targetRow && startCol == targetCol) {
            return 0;
        }

        int[][] moves = {
            {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},
            {1, 2}, {1, -2},
            {-1, 2}, {-1, -2}
        };

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            for (int[] move : moves) {
                int newRow = row + move[0];
                int newCol = col + move[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol]) {

                    if (newRow == targetRow && newCol == targetCol) {
                        return steps + 1;
                    }

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        return -1;
    }
}