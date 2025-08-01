import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] transformed = new int[n];

        // Step 1: transform array
        for (int i = 0; i < n; i++) {
            transformed[i] = (arr[i] > k) ? 1 : -1;
        }

        // Step 2: prefix sum + hashmap
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += transformed[i];

            // Case 1: whole prefix is positive
            if (prefixSum > 0) {
                maxLen = i + 1;
            }

            // Case 2: check if prefixSum - 1 seen before
            if (firstSeen.containsKey(prefixSum - 1)) {
                maxLen = Math.max(maxLen, i - firstSeen.get(prefixSum - 1));
            }

            // Store first occurrence
            if (!firstSeen.containsKey(prefixSum)) {
                firstSeen.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
