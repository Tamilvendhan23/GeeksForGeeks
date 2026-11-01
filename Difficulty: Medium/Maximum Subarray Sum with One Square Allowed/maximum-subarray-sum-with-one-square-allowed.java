class Solution {
    public int maximumSubarray(int[] arr) {
        int noSq = arr[0];          // no element squared yet
        int sq = arr[0] * arr[0];   // current element squared
        int ans = Math.max(noSq, sq);

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            // Best subarray ending at i with one square used:
            // 1. Square x now, extending a no-square subarray
            // 2. Square x now, start a new subarray
            // 3. Keep previous square, add x normally
            int newSq = Math.max(noSq + x * x, x * x);
            newSq = Math.max(newSq, sq + x);

            // Best subarray ending at i with no square used
            int newNoSq = Math.max(noSq + x, x);

            noSq = newNoSq;
            sq = newSq;

            ans = Math.max(ans, Math.max(noSq, sq));
        }

        return ans;
    }
}