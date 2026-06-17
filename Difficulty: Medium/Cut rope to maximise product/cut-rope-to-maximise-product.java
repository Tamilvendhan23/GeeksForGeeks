class Solution {
    public int maxProduct(int n) {
        // Base cases: n=2 or n=3 must be cut at least once
        if (n == 2 || n == 3) {
            return n - 1;
        }
        
        int product = 1;
        
        // Keep cutting parts of length 3 while n > 4
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        
        // Multiply by the remaining length (2, 3, or 4)
        return product * n;
    }
}