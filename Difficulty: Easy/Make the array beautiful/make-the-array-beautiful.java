class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : arr) {
            // If stack is not empty and top element has different sign
            if (!result.isEmpty()) {
                int last = result.get(result.size() - 1);
                // Check if signs are different (one negative, one non-negative)
                if ((last < 0 && num >= 0) || (last >= 0 && num < 0)) {
                    // Remove the last element (both are removed)
                    result.remove(result.size() - 1);
                } else {
                    // Same sign, add current element
                    result.add(num);
                }
            } else {
                // Stack empty, add current element
                result.add(num);
            }
        }
        
        return result;
    }
}