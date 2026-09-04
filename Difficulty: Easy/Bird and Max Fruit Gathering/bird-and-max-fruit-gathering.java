class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        long windowSum = 0;

        // Sum of the first m trees
        for (int i = 0; i < m; i++) {
            windowSum += arr.get(i);
        }

        long maxSum = windowSum;

        // Check all remaining circular windows
        for (int start = 1; start < n; start++) {
            windowSum -= arr.get(start - 1);
            windowSum += arr.get((start + m - 1) % n);

            maxSum = Math.max(maxSum, windowSum);
        }

        return (int) maxSum;
    }
}