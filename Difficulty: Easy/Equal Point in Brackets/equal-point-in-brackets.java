class Solution {
    public int findIndex(String s) {
        int n = s.length();
        
        // Count total closing brackets in the string
        int totalClosing = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                totalClosing++;
            }
        }
        
        int seenOpening = 0;
        int unseenClosing = totalClosing;
        
        // Try split positions from 0 to n
        for (int i = 0; i <= n; i++) {
            // At position i:
            // - seenOpening = number of '(' before i
            // - unseenClosing = number of ')' from i to end
            if (seenOpening == unseenClosing) {
                return i;
            }
            
            // Update counts for next position
            if (i < n) {
                if (s.charAt(i) == '(') {
                    seenOpening++;
                } else {
                    unseenClosing--;
                }
            }
        }
        
        // According to the problem statement, a valid point always exists.
        return n; // fallback (should not be reached for valid inputs)
    }
}