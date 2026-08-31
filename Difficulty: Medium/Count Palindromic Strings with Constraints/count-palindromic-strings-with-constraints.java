class Solution {
    private static final long MOD = 1_000_000_007L;

    public int palindromicStrings(int n, int k) {
        long total = 0;

        // For each length L from 1 to n, count valid palindromes
        for (int len = 1; len <= n; len++) {
            total = (total + countForLength(len, k)) % MOD;
        }

        return (int) total;
    }

    // Count palindromic strings of exact length 'len' using first k letters,
    // with each character used at most twice.
    private long countForLength(int len, int k) {
        // Number of independent positions we can choose in a palindrome:
        // For even len: len/2
        // For odd len: len/2 + 1 (middle character is independent)
        int positions = len / 2;
        if ((len & 1) == 1) {
            positions += 1;
        }

        // We need to choose 'positions' distinct characters from k, in order.
        // That's P(k, positions) = k * (k-1) * ... * (k - positions + 1)
        if (positions > k) {
            return 0; // not enough distinct characters
        }

        long ways = 1;
        for (int i = 0; i < positions; i++) {
            ways = (ways * (k - i)) % MOD;
        }

        return ways;
    }
}