class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // dp[0] = max sum when current element is replaced with 1
        // dp[1] = max sum when current element is kept as original
        int prevReplace = 0;
        int prevKeep = 0;

        for (int i = 1; i < n; i++) {
            // Current element replaced with 1
            int currReplace = Math.max(
                prevReplace,  // previous was also 1, |1-1| = 0
                prevKeep + Math.abs(1 - arr[i-1])  // previous was original
            );

            // Current element kept as original
            int currKeep = Math.max(
                prevReplace + Math.abs(arr[i] - 1),  // previous was 1
                prevKeep + Math.abs(arr[i] - arr[i-1])  // previous was original
            );

            prevReplace = currReplace;
            prevKeep = currKeep;
        }

        return Math.max(prevReplace, prevKeep);
    }
}