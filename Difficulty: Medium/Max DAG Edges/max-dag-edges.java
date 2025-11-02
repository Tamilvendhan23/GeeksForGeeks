import java.util.*;

class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Build adjacency matrix for O(1) access
        boolean[][] adj = new boolean[V][V];
        for (int[] e : edges) {
            adj[e[0]][e[1]] = true;
        }
        // Get topological order (Kahn's algorithm)
        int[] inDegree = new int[V];
        for (int[] e : edges) inDegree[e[1]]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (inDegree[i] == 0) q.add(i);
        
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int v = 0; v < V; v++) {
                if (adj[u][v]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) q.add(v);
                }
            }
        }
        
        // For i < j in topo, you can add edge topo[i] -> topo[j] if it doesn't already exist
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                int u = topo.get(i), v = topo.get(j);
                if (!adj[u][v]) count++;
            }
        }
        return count;
    }
}
