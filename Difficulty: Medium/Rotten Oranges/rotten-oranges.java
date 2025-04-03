//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        if (mat == null || mat.length == 0) return -1;

        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Populate the queue with initially rotten oranges and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh orange exists, return 0
        if (freshCount == 0) return 0;

        int time = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int x = rotten[0], y = rotten[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] == 1) {
                        mat[newX][newY] = 2; // Rot the fresh orange
                        queue.add(new int[]{newX, newY});
                        freshCount--;
                        rotted = true;
                    }
                }
            }
            if (rotted) time++;
        }

        // Step 3: If there are still fresh oranges left, return -1
        return freshCount == 0 ? time : -1;
    }
}
