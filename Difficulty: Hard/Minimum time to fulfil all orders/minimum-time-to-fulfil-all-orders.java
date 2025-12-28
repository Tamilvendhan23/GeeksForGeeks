class Solution {
    public int minTime(int[] ranks, int n) {
        int m = ranks.length;
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }

        long low = 0;
        // Worst case: fastest chef makes all donuts
        long high = (long) minRank * n * (n + 1) / 2;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canMake(ranks, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private boolean canMake(int[] ranks, int n, long time) {
        long donuts = 0;
        for (int r : ranks) {
            // For each chef, compute max k such that r * k * (k + 1) / 2 <= time
            long lo = 0, hi = n; // a chef never needs to make more than n donuts
            while (lo < hi) {
                long mid = lo + (hi - lo + 1) / 2;
                long neededTime = r * mid * (mid + 1) / 2;
                if (neededTime <= time) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            donuts += lo;
            if (donuts >= n) return true;
        }
        return donuts >= n;
    }
}
