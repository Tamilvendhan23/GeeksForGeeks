class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }

        Arrays.fill(vis, false);
        dfs(candidate, adj, vis);

        for (boolean b : vis) {
            if (!b) return -1;
        }

        return candidate;
    }

    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) dfs(v, adj, vis);
        }
    }
}