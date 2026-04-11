class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        int count = 0;
        int len = 1;  // length of current strictly increasing segment ending at i
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;  // extend the current strictly increasing segment
            } else {
                // current segment ended; add all subarrays of length >= 2 inside it
                if (len >= 2) {
                    count += len * (len - 1) / 2;
                }
                len = 1;  // reset length for new segment starting at i
            }
        }
        
        // handle the last segment
        if (len >= 2) {
            count += len * (len - 1) / 2;
        }
        
        return count;
    }
}