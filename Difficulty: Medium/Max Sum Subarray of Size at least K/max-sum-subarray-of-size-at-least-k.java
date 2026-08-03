class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;
        int[] maxEnd = new int[n];

        maxEnd[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            ans = Math.max(ans, windowSum);
            ans = Math.max(ans, windowSum + Math.max(0, maxEnd[i - k]));
        }

        return ans;
    }
}