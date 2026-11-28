class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        boolean[] visited = new boolean[adj.size()];
        return dfs(u, v, adj, visited);
    }

    private boolean dfs(int curr, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (curr == v) return true;
        if (visited[curr]) return false;
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor] && dfs(neighbor, v, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}