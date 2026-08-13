class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // Build adjacency list: adj[u] = list of [v, w]
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            adj.get(u).add(new int[]{v, w});
        }

        // Compute in-degrees for topological sort
        int[] indeg = new int[V];
        for (ArrayList<Integer> e : edges) {
            int v = e.get(1);
            indeg[v]++;
        }

        // Topological sort using Kahn's algorithm
        int[] topo = new int[V];
        int idx = 0;
        java.util.Queue<Integer> q = new java.util.ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                }
            }
        }

        // Longest path distances from src
        int[] dist = new int[V];
        int INF_NEG = Integer.MIN_VALUE;
        for (int i = 0; i < V; i++) dist[i] = INF_NEG;
        dist[src] = 0;

        // Process vertices in topological order
        for (int i = 0; i < V; i++) {
            int u = topo[i];
            if (dist[u] == INF_NEG) continue; // unreachable from src
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[v] == INF_NEG || dist[v] < dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;
    }
}