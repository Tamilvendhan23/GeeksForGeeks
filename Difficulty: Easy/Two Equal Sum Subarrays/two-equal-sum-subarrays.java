class Solution {
    public boolean canSplit(int arr[]) {
        int n = arr.length;
        long totalSum = 0;
        
        // Compute total sum
        for (int x : arr) {
            totalSum += x;
        }
        
        long leftSum = 0;
        // Try every split position: [0...i] and [i+1...n-1]
        for (int i = 0; i < n - 1; i++) {
            leftSum += arr[i];
            if (2 * leftSum == totalSum) {
                return true;
            }
        }
        return false;
    }
}