class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 1;
        long high = (long) n * Math.min(s1, s2); // enough time using only faster scanner
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canScan(n, s1, s2, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    private boolean canScan(int n, int s1, int s2, long time) {
        long docs1 = time / s1;
        long docs2 = time / s2;

        // Prevent overflow; if either scanner alone can handle all documents, return true
        if (docs1 >= n || docs2 >= n) return true;

        return docs1 + docs2 >= n;
    }
}