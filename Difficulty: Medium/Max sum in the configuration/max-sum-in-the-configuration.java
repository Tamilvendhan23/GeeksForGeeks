class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        // Compute total sum of array elements
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Compute initial value of i*arr[i]
        int currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += i * arr[i];
        }
        
        int maxVal = currVal;
        
        // Try all rotations using the formula
        for (int j = 1; j < n; j++) {
            currVal = currVal + totalSum - n * arr[n - j];
            if (currVal > maxVal) {
                maxVal = currVal;
            }
        }
        
        return maxVal;
    }
}
