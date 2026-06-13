class Solution {
    public int computeValue(int n) {
        long MOD = 1000000007;
        
        // We need to compute C(2n, n) % MOD
        // Using the formula: C(2n, n) = (2n)! / (n! * n!)
        
        // Precompute factorials and their modular inverses
        int max = 2 * n;
        long[] fact = new long[max + 1];
        fact[0] = 1;
        
        for (int i = 1; i <= max; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // Compute modular inverse of n! using Fermat's little theorem
        // Since MOD is prime: a^(MOD-1) ≡ 1 (mod MOD)
        // So a^(-1) ≡ a^(MOD-2) (mod MOD)
        long nFactInv = modInverse(fact[n], MOD);
        
        // C(2n, n) = (2n)! * (n!)^(-1) * (n!)^(-1)
        long result = (fact[2 * n] * nFactInv) % MOD;
        result = (result * nFactInv) % MOD;
        
        return (int) result;
    }
    
    // Compute a^b % MOD using binary exponentiation
    private long modPow(long a, long b, long MOD) {
        long result = 1;
        a = a % MOD;
        
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        
        return result;
    }
    
    // Compute modular inverse using Fermat's little theorem
    private long modInverse(long a, long MOD) {
        return modPow(a, MOD - 2, MOD);
    }
}