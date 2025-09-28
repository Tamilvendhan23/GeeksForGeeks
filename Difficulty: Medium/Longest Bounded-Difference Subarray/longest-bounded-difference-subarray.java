import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = 0;
        int maxLen = 0, startIdx = 0; // Store length and start index of longest valid subarray

        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        while (right < n) {
            // Add current element to the TreeMap
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // Check window's min and max; shrink window if needed
            while (map.lastKey() - map.firstKey() > x) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // Update result if current window is longer
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
            right++;
        }

        // Prepare output: longest valid subarray starting earliest
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
