class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long totalHeight = 0;

        // Total sum of all stone heights
        for (int x : arr) {
            totalHeight += x;
        }

        // Edge case: for n == 1, the only possible pyramid is [1] if arr[0] >= 1
        // Cost = totalHeight - 1
        if (n == 1) {
            return (int)(totalHeight - 1);
        }

        // left[i] = max possible pyramid height at i considering only the left side
        int[] left = new int[n];
        // right[i] = max possible pyramid height at i considering only the right side
        int[] right = new int[n];

        // Build left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1] + 1, arr[i]);
        }

        // Build right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1] + 1, arr[i]);
        }

        long maxPyramidSum = 0;

        // For each index as peak, max pyramid height is min(left[i], right[i])
        for (int i = 0; i < n; i++) {
            int peakHeight = Math.min(left[i], right[i]);
            long pyramidSum = (long)peakHeight * peakHeight; // sum of 1..h..1 = h^2
            if (pyramidSum > maxPyramidSum) {
                maxPyramidSum = pyramidSum;
            }
        }

        // Minimum cost = total original height - height used in best pyramid
        return (int)(totalHeight - maxPyramidSum);
    }
}