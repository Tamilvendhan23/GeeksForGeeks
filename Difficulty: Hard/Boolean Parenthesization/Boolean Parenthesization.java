import java.util.Arrays;

class Solution {
    // Function to evaluate a boolean condition.
    private boolean evaluate(int b1, int b2, char op) {
        if (op == '&') return (b1 & b2) == 1;
        else if (op == '|') return (b1 | b2) == 1;
        return (b1 ^ b2) == 1;
    }

    // Function which returns the number of ways s[i:j] evaluates to req.
    private int countRecur(int i, int j, int req, String s, int[][][] memo) {
        // Base case: if single character, check if it matches required boolean
        if (i == j) {
            return (req == (s.charAt(i) == 'T' ? 1 : 0)) ? 1 : 0;
        }

        // If already computed, return stored value
        if (memo[i][j][req] != -1) {
            return memo[i][j][req];
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) { // Operators are at odd indices
            // Count ways left and right substrings evaluate to true and false.
            int leftTrue = countRecur(i, k - 1, 1, s, memo);
            int leftFalse = countRecur(i, k - 1, 0, s, memo);
            int rightTrue = countRecur(k + 1, j, 1, s, memo);
            int rightFalse = countRecur(k + 1, j, 0, s, memo);

            // Compute ways based on operator
            if (evaluate(1, 1, s.charAt(k)) == (req == 1)) ans += leftTrue * rightTrue;
            if (evaluate(1, 0, s.charAt(k)) == (req == 1)) ans += leftTrue * rightFalse;
            if (evaluate(0, 1, s.charAt(k)) == (req == 1)) ans += leftFalse * rightTrue;
            if (evaluate(0, 0, s.charAt(k)) == (req == 1)) ans += leftFalse * rightFalse;
        }

        return memo[i][j][req] = ans;
    }

    public int countWays(String s) {
        int n = s.length();
        int[][][] memo = new int[n][n][2];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return countRecur(0, n - 1, 1, s, memo);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "T|T&F^T";
        System.out.println(sol.countWays(s)); // Output: 4
    }
}
