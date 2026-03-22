import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Find all initial rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;
        
        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        
        // Step 2: BFS - process level by level (each level = 1 unit time)
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                
                // Check all 4 adjacent cells
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    // Valid bounds, fresh orange, not visited
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2;  // Rot it
                        freshCount--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            // Only increment time if we processed some oranges this level
            if (!queue.isEmpty()) {
                time++;
            }
        }
        
        // Step 3: Check if all fresh oranges are rotten
        return freshCount == 0 ? time : -1;
    }
}