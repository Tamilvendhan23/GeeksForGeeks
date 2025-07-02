import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        int maxLength = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int right = 0; right < arr.length; right++) {
            // Add current element to the map or update its count
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            // If there are more than 2 distinct integers, shrink window from the left
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            
            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}