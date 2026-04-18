class Solution {
    int maxOnes(int[] arr) {
        int n = arr.length;
        
        // Count total 1s initially
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }
        
        // Convert to gains: 0->+1, 1->-1
        // Find max subarray sum (max gain from one flip)
        int maxGain = 0;          // can choose to flip nothing
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int val = (arr[i] == 0) ? 1 : -1;
            cur = Math.max(val, cur + val);
            maxGain = Math.max(maxGain, cur);
        }
        
        return totalOnes + maxGain;
    }
}