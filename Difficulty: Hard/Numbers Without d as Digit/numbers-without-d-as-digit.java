class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        char[] digits = String.valueOf(n).toCharArray();
        Integer[][][] memo = new Integer[digits.length + 1][2][2];

        // Count valid numbers from 0 to n.
        // Zero itself is included internally, so subtract it at the end.
        return solve(0, 1, 0, digits, d, memo) - 1;
    }

    private int solve(int pos, int tight, int started,
                      char[] digits, int forbidden,
                      Integer[][][] memo) {

        if (pos == digits.length) {
            // One complete number has been formed.
            return 1;
        }

        if (memo[pos][tight][started] != null) {
            return memo[pos][tight][started];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;
        int count = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == limit) ? 1 : 0;

            // Leading zeroes do not represent an actual digit.
            int nextStarted = started;
            if (started == 0 && digit != 0) {
                nextStarted = 1;
            }

            // Ignore leading zeroes, but reject forbidden actual digits.
            if (nextStarted == 1 && digit == forbidden) {
                continue;
            }

            count += solve(
                pos + 1,
                nextTight,
                nextStarted,
                digits,
                forbidden,
                memo
            );
        }

        return memo[pos][tight][started] = count;
    }
}