class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        if (n == 1) {
            return Math.max(h[0], l[0]);
        }

        // Best result up to day 0
        int prev2 = Math.max(h[0], l[0]);

        // Best result up to day 1:
        // high effort on day 1 requires skipping day 0
        int prev1 = Math.max(prev2 + l[1], h[1]);

        for (int i = 2; i < n; i++) {
            int lowEffort = prev1 + l[i];
            int highEffort = prev2 + h[i];

            int current = Math.max(lowEffort, highEffort);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}