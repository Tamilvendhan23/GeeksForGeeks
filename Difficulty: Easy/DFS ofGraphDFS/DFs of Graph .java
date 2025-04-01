import java.util.*;

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        // Start DFS from vertex 0
        dfsHelper(0, adj, visited, result);
        
        return result;
    }
    
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        // Mark the current node as visited and add it to the result
        visited[node] = true;
        result.add(node);
        
        // Traverse the neighbors in the given order
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
    
    // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
    // Space Complexity: O(V) due to the visited array and recursion stack
}
