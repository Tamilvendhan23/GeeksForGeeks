class Solution {
    int countWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;
        
        int prev2 = k;      // ways for 1 post
        int prev1 = k * k;  // ways for 2 posts
        
        for (int i = 3; i <= n; i++) {
            int curr = prev1 * (k - 1) + prev2 * (k - 1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}