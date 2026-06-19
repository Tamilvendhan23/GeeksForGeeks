import java.util.*;

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Build prefix sum array
        long[] prefixSum = new long[n + 1];
        for (int j = 0; j < n; j++) {
            prefixSum[j + 1] = prefixSum[j] + arr[j];
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result.add(0);
                continue;
            }
            
            // Median index for prefix [0..i]
            int mid = i / 2;
            int median = arr[mid];
            
            // Left part: [0..mid-1], count = mid
            // Cost = median * mid - sum(arr[0..mid-1])
            long leftSum = prefixSum[mid];  // sum of arr[0..mid-1]
            long leftCost = median * mid - leftSum;
            
            // Right part: [mid+1..i], count = i - mid
            // Cost = sum(arr[mid+1..i]) - median * (i - mid)
            long rightSum = prefixSum[i + 1] - prefixSum[mid + 1];  // sum of arr[mid+1..i]
            long rightCost = rightSum - median * (i - mid);
            
            result.add((int)(leftCost + rightCost));
        }
        
        return result;
    }
}