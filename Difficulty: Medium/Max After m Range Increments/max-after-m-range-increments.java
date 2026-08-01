class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // Create difference array of size n+1 to handle b[i]+1 safely
        long[] diff = new long[n + 1];
        
        // Apply all range operations using difference array technique
        int m = a.length;
        for (int i = 0; i < m; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n + 1) {
                diff[b[i] + 1] -= k[i];
            }
        }
        
        // Compute prefix sum and track maximum
        long max = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            max = Math.max(max, currentSum);
        }
        
        return (int) max;
    }
}