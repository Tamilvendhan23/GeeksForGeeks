
class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;

        // Pair height and cost together
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = heights[i];
            pairs[i][1] = cost[i];
        }

        // Sort by height
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        // Find total weight
        long totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += pairs[i][1];
        }

        // Find weighted median
        long prefix = 0;
        int targetHeight = 0;
        for (int i = 0; i < n; i++) {
            prefix += pairs[i][1];
            if (prefix >= (totalWeight + 1) / 2) {
                targetHeight = pairs[i][0];
                break;
            }
        }

        // Calculate total cost to make all heights equal to targetHeight
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += 1L * Math.abs(heights[i] - targetHeight) * cost[i];
        }

        return (int) result;
    }
}