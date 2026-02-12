class Solution {
    private boolean canAchieve(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] water = new long[n];
        long daysLeft = k;
        
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                water[i] = water[i - 1];
            }
            long currHeight = (long)arr[i] + water[i];
            if (i >= w) {
                currHeight -= water[i - w];
            }
            if (currHeight < target) {
                long need = target - currHeight;
                water[i] += need;
                daysLeft -= need;
                if (daysLeft < 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int maxMinHeight(int[] arr, int k, int w) {
        long minH = Integer.MAX_VALUE;
        for (int h : arr) {
            if (h < minH) minH = h;
        }
        long low = minH;
        long high = minH + k;
        long ans = minH;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }
}
