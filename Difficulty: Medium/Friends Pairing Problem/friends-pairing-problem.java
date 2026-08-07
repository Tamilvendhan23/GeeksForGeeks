class Solution {
    public int countFriendsPairings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev2 = 1; // f(1)
        int prev1 = 2; // f(2)
        int curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = prev1 + (i - 1) * prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}