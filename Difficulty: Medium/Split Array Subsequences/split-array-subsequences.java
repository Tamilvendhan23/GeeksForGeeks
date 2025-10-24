import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        // Count occurrences
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            if (count.get(num) == 0) continue;
            
            // Use this number
            count.put(num, count.get(num) - 1);
            
            // Case 1: Extend a previous sequence
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            // Case 2: Start a new sequence of length k
            else {
                boolean canStart = true;
                for (int i = 1; i < k; i++) {
                    if (count.getOrDefault(num + i, 0) <= 0) {
                        canStart = false;
                        break;
                    }
                }
                if (!canStart) return false;
                
                // Consume k-1 next numbers
                for (int i = 1; i < k; i++) {
                    count.put(num + i, count.get(num + i) - 1);
                }
                
                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }
        
        return true;
    }
}
