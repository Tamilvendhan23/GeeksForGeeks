import java.util.*;

class Solution {
    private int[] disc, low, parent;
    private boolean[] visited, ap;
    private int timer;
    private List<List<Integer>> adj;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        Solution sol = new Solution();
        return sol.findAPs(V, edges);
    }

    private ArrayList<Integer> findAPs(int V, int[][] edges) {
        // Build adjacency list
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        disc    = new int[V];
        low     = new int[V];
        parent  = new int[V];
        visited = new boolean[V];
        ap      = new boolean[V];
        timer   = 0;
        Arrays.fill(parent, -1);

        // Handle disconnected graphs
        for (int i = 0; i < V; i++)
            if (!visited[i]) dfs(i);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (ap[i]) result.add(i);

        if (result.isEmpty()) result.add(-1);
        Collections.sort(result);
        return result;
    }

    private void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v);

                // Propagate lowest reachable time upward
                low[u] = Math.min(low[u], low[v]);

                // Case 1: u is root with 2+ children
                if (parent[u] == -1 && children > 1) ap[u] = true;

                // Case 2: u is non-root, v can't bypass u
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;

            } else if (v != parent[u]) {
                // Back edge: update low with already-visited ancestor
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}