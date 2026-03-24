class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // Build adjacency list and indegree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for (int[] pre : prerequisites) {
            int x = pre[0], y = pre[1];  // x depends on y (edge y -> x)
            adj.get(y).add(x);
            indegree[x]++;
        }
        
        // Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        
        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            
            // Reduce indegree of neighbors
            for (int neighbor : adj.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return visited == n;  // All courses visited = no cycle
    }
}