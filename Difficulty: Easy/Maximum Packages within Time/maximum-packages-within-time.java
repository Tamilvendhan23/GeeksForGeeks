class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int k = Math.min(totalTime, n); // maximum locations that can be visited

        long windowSum = 0;
        long maxPackages = 0;

        for (int i = 0; i < n; i++) {
            windowSum += arr[i];

            if (i >= k) {
                windowSum -= arr[i - k];
            }

            if (i >= k - 1) {
                maxPackages = Math.max(maxPackages, windowSum);
            }
        }

        return (int) maxPackages;
    }
}