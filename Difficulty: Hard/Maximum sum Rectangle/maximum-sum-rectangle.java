class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        // Left boundary
        for (int left = 0; left < m; left++) {
            int[] temp = new int[n]; // Temporary row sums

            // Right boundary
            for (int right = left; right < m; right++) {
                // Add current column to each row
                for (int row = 0; row < n; row++) {
                    temp[row] += mat[row][right];
                }
                // Now find max subarray sum in temp using Kadane's algorithm
                int currSum = kadane(temp);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
    
    // Standard Kadane's Algorithm for 1D array
    private int kadane(int[] arr) {
        int maxHere = arr[0], maxTotal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxHere = Math.max(arr[i], maxHere + arr[i]);
            maxTotal = Math.max(maxTotal, maxHere);
        }
        return maxTotal;
    }
}
