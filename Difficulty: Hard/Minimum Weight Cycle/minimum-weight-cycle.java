//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


// import java.util.*;

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        // Step 1: Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // Undirected graph
        }
        
        int minCycle = Integer.MAX_VALUE;
        
        // Step 2: Try each edge as part of the cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            // Step 3: Run Dijkstra's to find shortest path from u to v excluding edge (u, v)
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[u] = 0;
            pq.offer(new int[]{u, 0});
            
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0], currDist = curr[1];
                
                if (currDist > dist[node]) continue;
                
                // Explore neighbors
                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0], weight = neighbor[1];
                    
                    // Skip the edge (u, v) or (v, u)
                    if ((node == u && nextNode == v) || (node == v && nextNode == u)) {
                        continue;
                    }
                    
                    if (dist[nextNode] > dist[node] + weight) {
                        dist[nextNode] = dist[node] + weight;
                        pq.offer(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }
            
            // Step 4: If a path from u to v exists, calculate cycle weight
            if (dist[v] != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }
        }
        
        // Step 5: Return result (handle case where no cycle exists)
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}