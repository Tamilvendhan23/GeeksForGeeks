class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        int[][] range = new int[n][2];
        int validCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                range[validCount][0] = left;
                range[validCount][1] = right;
                validCount++;
            }
        }
        
        if (validCount == 0) return -1;
        
        // Sort by start time, then by descending end time
        Arrays.sort(range, 0, validCount, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int men = 0;
        int i = 0;
        int maxi = -1;
        
        while (maxi < n - 1) {
            if (i >= validCount) return -1;
            if (range[i][0] > maxi + 1) return -1;
            
            int best = maxi;
            while (i < validCount && range[i][0] <= maxi + 1) {
                best = Math.max(best, range[i][1]);
                i++;
            }
            
            men++;
            maxi = best;
        }
        
        return men;
    }
}
