class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        
        // Step 1: Count total 1s
        int totalOnes = 0;
        for (int x : arr)
            if (x == 1)
                totalOnes++;
                
        // If no 1s, return -1
        if (totalOnes == 0)
            return -1;
        
        // Step 2: Window of length = totalOnes
        int k = totalOnes;
        int countOnes = 0;
        
        // Count 1s in first window [0, k-1]
        for (int i = 0; i < k; i++)
            countOnes += arr[i];
            
        int maxOnes = countOnes;
        
        // Step 3: Slide the window
        for (int i = k; i < n; i++) {
            countOnes += arr[i];        // add new element
            countOnes -= arr[i - k];    // remove old element
            if (countOnes > maxOnes)
                maxOnes = countOnes;
        }
        
        // Step 4: Min swaps = zeros in best window
        return k - maxOnes;
    }
}