import java.util.*;

class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        // Build adjacency list with only straight edges
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Also store curved edges separately
        List<int[]> curved = new ArrayList<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w1 = edge[2]; // straight edge
            int w2 = edge[3]; // curved edge
            
            adj.get(u).add(new int[]{v, w1});
            adj.get(v).add(new int[]{u, w1});
            curved.add(new int[]{u, v, w2});
        }
        
        // Dijkstra from a
        int[] da = dijkstra(a, V, adj);
        // Dijkstra from b
        int[] db = dijkstra(b, V, adj);
        
        // Initialize answer with shortest path without curved edges
        int ans = da[b];
        
        // Try using each curved edge exactly once
        for (int[] cur : curved) {
            int u = cur[0];
            int v = cur[1];
            int w2 = cur[2];
            
            // a -> u -> v (curved) -> b
            if (da[u] < Integer.MAX_VALUE && db[v] < Integer.MAX_VALUE) {
                ans = Math.min(ans, da[u] + w2 + db[v]);
            }
            // a -> v -> u (curved) -> b
            if (da[v] < Integer.MAX_VALUE && db[u] < Integer.MAX_VALUE) {
                ans = Math.min(ans, da[v] + w2 + db[u]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int[] dijkstra(int src, int V, List<List<int[]>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        return dist;
    }
}
