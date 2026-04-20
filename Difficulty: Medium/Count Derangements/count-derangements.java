class Solution {
    public int derangeCount(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        
        int prev2 = 1;  // D(0)
        int prev1 = 0;  // D(1)
        int curr = 0;
        
        for (int i = 2; i <= n; i++) {
            curr = (i - 1) * (prev1 + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
    }
};