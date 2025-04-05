//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        // Traverse each cell of the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    // DFS to mark all connected 'L' cells
    private void dfs(char[][] grid, int x, int y, int n, int m) {
        // Boundary check and base case
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 'L') {
            return;
        }

        // Mark as visited
        grid[x][y] = 'V';

        // Explore all 8 directions
        for (int dir = 0; dir < 8; dir++) {
            dfs(grid, x + dx[dir], y + dy[dir], n, m);
        }
    }
}
