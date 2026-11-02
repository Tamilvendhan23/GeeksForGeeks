class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = in current path, 2 = processed
        int[] position = new int[n]; // index of node in current path
        int[] path = new int[n];

        int ans = -1;

        for (int start = 0; start < n; start++) {
            if (state[start] != 0) continue;

            int len = 0;
            int curr = start;

            while (curr != -1 && state[curr] == 0) {
                state[curr] = 1;
                position[curr] = len;
                path[len++] = curr;
                curr = edge[curr];
            }

            if (curr != -1 && state[curr] == 1) {
                // Cycle begins at curr
                int cycleStartIndex = position[curr];
                int sum = 0;

                for (int i = cycleStartIndex; i < len; i++) {
                    sum += path[i];
                }

                ans = Math.max(ans, sum);
            }

            // Mark all nodes in this traversal as processed
            for (int i = 0; i < len; i++) {
                state[path[i]] = 2;
            }
        }

        return ans;
    }
}