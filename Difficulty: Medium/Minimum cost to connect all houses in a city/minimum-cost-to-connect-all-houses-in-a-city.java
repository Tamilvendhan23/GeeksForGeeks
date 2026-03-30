class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        if (n == 0) return 0;
        
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE / 2);
        minDist[0] = 0;
        
        int totalCost = 0;
        
        for (int count = 0; count < n; count++) {
            // Find unvisited house with minimum minDist
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (u == -1 || minDist[i] < minDist[u])) {
                    u = i;
                }
            }
            
            if (u == -1) return -1; // Not connected, but per constraints always possible
            
            visited[u] = true;
            totalCost += minDist[u];
            
            // Update distances to unvisited houses
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }
        
        return totalCost;
    }
}