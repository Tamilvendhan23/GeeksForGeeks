import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Step 2: Memoization array, -1 indicates uncomputed
        int[] memo = new int[V];
        Arrays.fill(memo, -1);

        // Step 3: Call DFS
        return dfs(src, dest, graph, memo);
    }

    private int dfs(int node, int dest, List<List<Integer>> graph, int[] memo) {
        // Base case: reached destination
        if (node == dest) return 1;

        // Return memoized value
        if (memo[node] != -1) return memo[node];

        int count = 0;
        for (int neighbor : graph.get(node)) {
            count += dfs(neighbor, dest, graph, memo);
        }

        // Memoize and return
        memo[node] = count;
        return count;
    }
}
