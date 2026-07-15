class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] inc = new int[n]; // non-decreasing ending at i
        int[] dec = new int[n]; // non-increasing starting at i
        
        // inc[i]: length of non-decreasing subarray ending at i
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        
        // dec[i]: length of non-increasing subarray starting at i
        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }
        
        // maximum bitonic subarray length
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int len = inc[i] + dec[i] - 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }
        
        return maxLen;
    }
}