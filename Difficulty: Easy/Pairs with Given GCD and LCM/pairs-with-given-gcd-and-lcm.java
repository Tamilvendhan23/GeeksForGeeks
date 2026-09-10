class Solution {
    public int pairCount(int x, int y) {
        // If LCM is not a multiple of GCD, no valid pair exists
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int distinctPrimeFactors = 0;

        // Count distinct prime factors of n
        // Handle factor 2
        if (n % 2 == 0) {
            distinctPrimeFactors++;
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        // Handle odd factors from 3 onwards
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                distinctPrimeFactors++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        // If n > 1 now, it's a prime factor
        if (n > 1) {
            distinctPrimeFactors++;
        }

        // Answer is 2^(number of distinct prime factors)
        return 1 << distinctPrimeFactors;
    }
}