class Solution {
    public int getCount(int n) {
        int count = 0;

        // L = length of the consecutive sequence (must be >= 2)
        for (int L = 2; (long)L * (L - 1) / 2 < n; L++) {
            // numerator = n - L*(L-1)/2
            long numerator = n - (long)L * (L - 1) / 2;

            // numerator must be positive and divisible by L
            if (numerator > 0 && numerator % L == 0) {
                long a = numerator / L;  // starting number
                if (a >= 1) {
                    count++;
                }
            }
        }

        return count;
    }
}