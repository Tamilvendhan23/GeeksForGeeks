import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        // Base case
        result.add("0");
        result.add("1");
        
        for (int i = 2; i <= n; i++) {
            int size = result.size();
            
            // Step 1: reflect (reverse order)
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j));
            }
            
            // Step 2: add prefixes
            for (int j = 0; j < size; j++) {
                result.set(j, "0" + result.get(j));
            }
            for (int j = size; j < result.size(); j++) {
                result.set(j, "1" + result.get(j));
            }
        }
        
        // Edge case: n = 1 already handled, but ensure format
        if (n == 1) return result;
        
        return result;
    }
}