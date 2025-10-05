import java.util.*;

class Solution {
    // Directions: D, L, R, U (sorted for lexicographical order)
    private static final String DIRS = "DLRU";
    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, -1, 1, 0};

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> results = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        
        if(maze[0][0] == 0) return results;
        dfs(0, 0, n, maze, visited, new StringBuilder(), results);
        Collections.sort(results); // Ensure lexicographical order
        return results;
    }
    
    private void dfs(int x, int y, int n, int[][] maze, boolean[][] visited, StringBuilder path, ArrayList<String> results) {
        if(x == n-1 && y == n-1) {
            results.add(path.toString());
            return;
        }
        
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) { // D, L, R, U in lex order
            int nx = x + DX[i], ny = y + DY[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n &&
               maze[nx][ny] == 1 && !visited[nx][ny]) {
                path.append(DIRS.charAt(i));
                dfs(nx, ny, n, maze, visited, path, results);
                path.deleteCharAt(path.length() - 1); // Backtrack
            }
        }
        visited[x][y] = false;
    }
}
