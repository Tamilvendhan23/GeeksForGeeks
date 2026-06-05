class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        // Correct k based on whether n is a power of 2
        if ((n & (n - 1)) == 0) {  // Check if n is power of 2
            k = k / 2;
        } else {
            k = k * 2;
        }
        
        // If k >= n, we can't remove k characters (result would be empty or invalid)
        if (k >= n) {
            return "-1";
        }
        
        // Use monotonic stack to build lexicographically smallest string
        StringBuilder stack = new StringBuilder();
        int removalsRemaining = k;
        
        for (char c : s.toCharArray()) {
            // While we can still remove characters and current char is smaller than stack top
            while (removalsRemaining > 0 && stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                removalsRemaining--;
            }
            stack.append(c);
        }
        
        // If we still need to remove characters, remove from the end
        while (removalsRemaining > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            removalsRemaining--;
        }
        
        // If result is empty, return -1
        if (stack.length() == 0) {
            return "-1";
        }
        
        return stack.toString();
    }
}