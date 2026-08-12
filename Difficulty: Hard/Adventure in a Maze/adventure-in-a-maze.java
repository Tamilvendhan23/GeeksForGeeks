import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        final long MOD = 1_000_000_007L;

        long[][] ways = new long[n][n];
        int[][] best = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                best[i][j] = -1;
            }
        }

        ways[0][0] = 1;
        best[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (best[i][j] == -1) {
                    continue;
                }

                // Move right: values 1 and 3 allow right movement.
                if ((grid[i][j] == 1 || grid[i][j] == 3)
                        && j + 1 < n) {

                    ways[i][j + 1] =
                            (ways[i][j + 1] + ways[i][j]) % MOD;

                    best[i][j + 1] = Math.max(
                            best[i][j + 1],
                            best[i][j] + grid[i][j + 1]
                    );
                }

                // Move down: values 2 and 3 allow downward movement.
                if ((grid[i][j] == 2 || grid[i][j] == 3)
                        && i + 1 < n) {

                    ways[i + 1][j] =
                            (ways[i + 1][j] + ways[i][j]) % MOD;

                    best[i + 1][j] = Math.max(
                            best[i + 1][j],
                            best[i][j] + grid[i + 1][j]
                    );
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) ways[n - 1][n - 1]);

        int maxAdventure = best[n - 1][n - 1] == -1
                ? 0
                : best[n - 1][n - 1];

        result.add(maxAdventure);

        return result;
    }
}