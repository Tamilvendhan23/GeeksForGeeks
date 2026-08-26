class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        long[] dist = new long[V];

        // All vertices are initially reachable through a virtual source.
        // Therefore, dist[] is initialized to 0 by default.
        for (int i = 0; i < V; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    updated = true;

                    // A relaxation on the V-th pass means a negative cycle.
                    if (i == V - 1) {
                        return true;
                    }
                }
            }

            // No changes means no negative cycle is reachable.
            if (!updated) {
                return false;
            }
        }

        return false;
    }
}