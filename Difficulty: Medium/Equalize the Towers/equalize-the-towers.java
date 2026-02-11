//optimized

class Solution {

    private long findCost(int[] heights, int[] cost, int h) {
        long res = 0;
        for (int i = 0; i < heights.length; i++) {
            res += (long) Math.abs(heights[i] - h) * cost[i];
        }
        return res;
    }

    public int minCost(int[] heights, int[] cost) {
        int low = heights[0], high = heights[0];

        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            long costMid = findCost(heights, cost, mid);
            long costNext = findCost(heights, cost, mid + 1);

            if (costMid <= costNext) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) findCost(heights, cost, low);
    }
}
