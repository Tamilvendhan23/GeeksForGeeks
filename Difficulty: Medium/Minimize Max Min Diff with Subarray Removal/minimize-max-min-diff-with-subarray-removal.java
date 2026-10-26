class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;

        int[] sufMax = new int[n];
        int[] sufMin = new int[n];

        sufMax[n - 1] = arr[n - 1];
        sufMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(arr[i], sufMax[i + 1]);
            sufMin[i] = Math.min(arr[i], sufMin[i + 1]);
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: remove prefix arr[0..k-1]
        ans = Math.min(ans, sufMax[k] - sufMin[k]);

        int preMax = arr[0];
        int preMin = arr[0];

        // Case 2: remove arr[i..i+k-1], leaving prefix [0..i-1] and suffix [i+k..n-1]
        for (int i = 1; i + k < n; i++) {
            preMax = Math.max(preMax, arr[i - 1]);
            preMin = Math.min(preMin, arr[i - 1]);

            int mx = Math.max(preMax, sufMax[i + k]);
            int mn = Math.min(preMin, sufMin[i + k]);

            ans = Math.min(ans, mx - mn);
        }

        // Case 3: remove suffix arr[n-k..n-1]
        // Remaining prefix is arr[0..n-k-1]
        preMax = Math.max(preMax, arr[n - k - 1]);
        preMin = Math.min(preMin, arr[n - k - 1]);

        ans = Math.min(ans, preMax - preMin);

        return ans;
    }
}