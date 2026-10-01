class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];

        // Build graph: u -> v means v depends on u
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // earliestFinish[i] = earliest time module i can finish
        int[] earliestFinish = new int[n];
        for (int i = 0; i < n; i++) {
            earliestFinish[i] = duration[i];
        }

        // Queue for nodes with in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int processed = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            processed++;

            for (int v : adj.get(u)) {
                // v can start only after u finishes
                earliestFinish[v] = Math.max(earliestFinish[v], earliestFinish[u] + duration[v]);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // If not all nodes processed, there's a cycle
        if (processed != n) {
            return -1;
        }

        // Answer is the maximum finish time among all modules
        int ans = 0;
        for (int t : earliestFinish) {
            ans = Math.max(ans, t);
        }
        return ans;
    }
}