class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        int n = s.length();
        int ALPHA = 26;
        final int INF = (int)1e9;
        int[][] dist = new int[ALPHA][ALPHA];
        // Initialize distances
        for (int i = 0; i < ALPHA; i++)
            Arrays.fill(dist[i], INF);
        for (int i = 0; i < ALPHA; i++)
            dist[i][i] = 0;
        // Add provided transformations
        for (int i = 0; i < transform.length; i++) {
            int from = transform[i][0] - 'a';
            int to = transform[i][1] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        // Floyd-Warshall: find min cost between every character pair
        for (int k = 0; k < ALPHA; k++) 
            for (int i = 0; i < ALPHA; i++) 
                for (int j = 0; j < ALPHA; j++) 
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (cs == ct) continue; // already matching, no cost
            
            int minCost = INF;
            // Try making both chars to common intermediate char
            for (int c = 0; c < ALPHA; c++) {
                int cost1 = dist[cs - 'a'][c];
                int cost2 = dist[ct - 'a'][c];
                if (cost1 < INF && cost2 < INF) {
                    minCost = Math.min(minCost, cost1 + cost2);
                }
            }
            if (minCost == INF) return -1; // impossible for this position
            totalCost += minCost;
        }
        return totalCost;
    }
}
