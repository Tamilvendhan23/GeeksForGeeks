class Solution {
    public boolean isPower(int x, int y) {
        // Handle special case: any number^0 = 1, but since y >= 1, only check if y == 1
        if (y == 1) {
            return true;
        }
        
        // Handle x == 1: only 1^1 = 1, but since y >= 1, 1^y != y unless y=1 (already handled)
        if (x == 1) {
            return false;
        }
        
        // Repeatedly multiply by x until we reach or exceed y
        long power = x;  // Use long to avoid int overflow (y up to 10^9)
        while (power < y) {
            if (power > Integer.MAX_VALUE / x) {  // Check for overflow before multiply
                return false;  // power * x would overflow, can't reach exactly y
            }
            power *= x;
            if (power == y) {
                return true;
            }
        }
        return power == y;
    }
}