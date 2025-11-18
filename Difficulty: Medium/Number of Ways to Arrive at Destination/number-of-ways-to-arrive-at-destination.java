import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        int[] dist = new int[V];
        int[] ways = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // [distance, node]
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];
            if (d > dist[u]) continue;
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.offer(new int[]{dist[v], v});
                } else if (dist[v] == dist[u] + w) {
                    ways[v] += ways[u];
                }
            }
        }
        return ways[V-1];
    }
}
