class Solution {
    public int prefixStrings(int n) {
        long MOD = 1_000_000_007L;

        // Compute n-th Catalan number using DP
        // C[0] = 1, C[i] = sum(C[j] * C[i-1-j]) for j from 0 to i-1
        long[] catalan = new long[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + catalan[j] * catalan[i - 1 - j]) % MOD;
            }
        }

        return (int) catalan[n];
    }
}