class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        // XOR of first window
        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            // remove element going out of window
            currXor ^= arr[i - k];
            // add new element
            currXor ^= arr[i];

            if (currXor > maxXor) {
                maxXor = currXor;
            }
        }

        return maxXor;
    }
}
