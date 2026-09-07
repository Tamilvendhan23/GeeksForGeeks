class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;

        // next[incLast+1][decLast+1] stores DP values for idx+1
        int[][] next = new int[n + 1][n + 1];
        int[][] curr = new int[n + 1][n + 1];

        // Fill DP table in reverse order (idx from n-1 to 0)
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int incLast = -1; incLast < n; incLast++) {
                for (int decLast = -1; decLast < n; decLast++) {
                    // Option 1: Skip current element
                    int ans = 1 + next[incLast + 1][decLast + 1];

                    // Option 2: Include in increasing subsequence
                    if (incLast == -1 || arr[idx] > arr[incLast]) {
                        ans = Math.min(ans, next[idx + 1][decLast + 1]);
                    }

                    // Option 3: Include in decreasing subsequence
                    if (decLast == -1 || arr[idx] < arr[decLast]) {
                        ans = Math.min(ans, next[incLast + 1][idx + 1]);
                    }

                    curr[incLast + 1][decLast + 1] = ans;
                }
            }
            // Move current layer to next layer
            int[][] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0][0];
    }
}