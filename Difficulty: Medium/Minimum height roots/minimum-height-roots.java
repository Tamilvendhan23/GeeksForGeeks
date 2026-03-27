import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        // Step 1: Build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[V];
        
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        // Step 2: Initialize leaves
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        
        int remainingNodes = V;
        
        // Step 3: Trim leaves layer by layer
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    
                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        
        // Step 4: Remaining nodes are centers
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        
        return result;
    }
}