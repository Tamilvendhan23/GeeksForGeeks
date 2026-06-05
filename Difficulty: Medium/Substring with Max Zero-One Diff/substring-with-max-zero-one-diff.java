class Solution {
    int maxSubstring(String s) {
        int currentSum = 0;
        int maxSum = 0;
        
        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            // If character is '0', add 1; if '1', add -1
            // This transforms the problem to maximum subarray sum [web:20][web:22]
            currentSum += (s.charAt(i) == '0' ? 1 : -1);
            
            // If currentSum becomes negative, reset to 0 (discard this substring) [web:23]
            if (currentSum < 0) {
                currentSum = 0;
            }
            
            // Update maximum sum found so far [web:22]
            maxSum = Math.max(currentSum, maxSum);
        }
        
        // Return -1 if string has no '0' (all '1's), otherwise return maxSum [web:20][web:22]
        return maxSum == 0 ? -1 : maxSum;
    }
}