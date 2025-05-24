class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        int mod = 1000000007; // Not needed for this problem, but useful for large numbers
        long totalSum = 0;
        long prevSum = 0;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            long currSum = (num * (i + 1)) + (10 * prevSum);
            prevSum = currSum;
            totalSum += currSum;
        }

        return (int) totalSum;
    }
}
