class Solution {
    public int minConnect(int V, int[][] edges) {
        // If not enough edges to connect all hospitals, return -1
        if (edges.length < V - 1) return -1;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // Count connected components using DFS
        boolean[] visited = new boolean[V];
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        // Minimum required operations is (components - 1)
        return components - 1;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v, adj, visited);
        }
    }
}
