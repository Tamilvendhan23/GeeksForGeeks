import java.util.*;

class Solution {
    public int diameter(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // First BFS to find farthest node from node 0
        int farthest = bfs(0, adj, V)[0];
        // Second BFS from farthest node to find the diameter
        int[] bfsResult = bfs(farthest, adj, V);
        int diameter = bfsResult[1];
        return diameter;
    }
    
    // Helper BFS function: returns {farthest_node, distance}
    private int[] bfs(int src, List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        int farthestNode = src, distance = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                farthestNode = node;
                for (int nbr : adj.get(node)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.offer(nbr);
                    }
                }
            }
            // Increment distance after each level
            if (!q.isEmpty()) distance++;
        }
        return new int[]{farthestNode, distance};
    }
}
