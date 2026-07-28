import java.util.*;

class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];

            if (d != dist[node]) continue;
            if (node == dest) return d;

            for (int[] nei : adj.get(node)) {
                int next = nei[0], w = nei[1];
                if (d + w < dist[next]) {
                    dist[next] = d + w;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return -1;
    }
}