class Solution {
    public int subsequenceSum(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        long digitSum = 0;

        for (char c : s.toCharArray()) {
            digitSum = (digitSum + (c - '0')) % MOD;
        }

        long power = 1;
        for (int i = 1; i < n; i++) {
            power = (power * 2) % MOD;
        }

        return (int) ((digitSum * power) % MOD);
    }
}