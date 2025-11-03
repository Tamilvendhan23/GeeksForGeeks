class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);
        
        int[] state = new int[V]; // 0: unvisited, 1: visiting, 2: safe
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < V; i++)
            if (isSafe(i, adj, state))
                result.add(i);
        
        return result;
    }
    
    private boolean isSafe(int node, ArrayList<ArrayList<Integer>> adj, int[] state) {
        if (state[node] > 0) 
            return state[node] == 2;
        state[node] = 1;
        for (int nei : adj.get(node)) {
            if (!isSafe(nei, adj, state))
                return false;
        }
        state[node] = 2;
        return true;
    }
}
