class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();

        // prev2 = best extra weight up to i-2
        // prev1 = best extra weight up to i-1
        int prev2 = 0, prev1 = 0;

        for (int i = 1; i < n; i++) {
            int gain = (s.charAt(i) == s.charAt(i - 1)) ? 1 : 2;
            int curr = Math.max(prev1, prev2 + gain);
            prev2 = prev1;
            prev1 = curr;
        }

        // Every character starts with weight 1
        return n + prev1;
    }
}