import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(m, -1)));
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Initialize queue with all cells having 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans.get(i).set(j, 0);
                    q.add(new int[]{i, j});
                }
            }
        }
        
        // Directions: up, down, left, right
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && ans.get(nx).get(ny) == -1) {
                    ans.get(nx).set(ny, ans.get(x).get(y) + 1);
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return ans;
    }
}
