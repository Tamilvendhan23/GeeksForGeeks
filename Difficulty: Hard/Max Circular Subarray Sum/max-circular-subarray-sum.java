class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;

        // Step 1: Find max subarray sum using normal Kadane’s algorithm
        int maxNormal = kadane(arr);
        
        // Step 2: If all elements are negative, return maxNormal
        if (maxNormal < 0) return maxNormal;

        // Step 3: Compute total sum and min subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // invert the array for min subarray sum
        }

        // Step 4: Now, kadane on inverted array gives min subarray sum
        int minSubarraySum = kadane(arr);

        // Step 5: maxWrap = totalSum - minSubarraySum
        int maxWrap = totalSum + minSubarraySum; // because arr was inverted

        // Step 6: Return max of wrapped and normal
        return Math.max(maxNormal, maxWrap);
    }

    // Standard Kadane’s algorithm
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
