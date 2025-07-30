import java.util.*;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // base case: prefix sum zero before starting
        int count = 0;
        int prefixSum = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            // Check if there exists a prefix with sum (prefixSum - k)
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }
            
            // Store/update frequency of current prefixSum
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
