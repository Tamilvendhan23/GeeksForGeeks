class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // If start already equals end, 0 steps needed
        if (start == end) return 0;
        
        int MOD = 1000;
        int n = arr.length;
        
        // dist[i] = minimum steps to reach number i from start
        int[] dist = new int[MOD];
        for (int i = 0; i < MOD; i++) {
            dist[i] = -1; // -1 means unreachable
        }
        
        // BFS queue storing current number
        Queue<Integer> q = new LinkedList<>();
        
        // Start from the initial number
        dist[start] = 0;
        q.add(start);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            int steps = dist[node];
            
            // Try multiplying by each element in arr
            for (int i = 0; i < n; i++) {
                int num = (node * arr[i]) % MOD;
                
                // If this number hasn't been visited yet
                if (dist[num] == -1) {
                    dist[num] = steps + 1;
                    
                    // If we reached the end, return immediately
                    if (num == end) {
                        return dist[num];
                    }
                    
                    q.add(num);
                }
            }
        }
        
        // End is unreachable
        return -1;
    }
}