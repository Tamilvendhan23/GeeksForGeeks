import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        long count = 0;
        int prefixXor = 0;
        
        // Base case: XOR 0 occurs once
        map.put(0, 1);
        
        for (int num : arr) {
            prefixXor ^= num;
            
            // If (prefixXor ^ k) exists, add its frequency
            if (map.containsKey(prefixXor ^ k)) {
                count += map.get(prefixXor ^ k);
            }
            
            // Store/update prefixXor frequency
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
}