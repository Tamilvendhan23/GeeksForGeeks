import java.util.*;

class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int minPower = Integer.MAX_VALUE;

        for (int prime : primeFactors.keySet()) {
            int expInK = primeFactors.get(prime);
            int expInFact = countPrimeInFactorial(n, prime);
            minPower = Math.min(minPower, expInFact / expInK);
        }

        return minPower;
    }

    // Count of prime p in n!
    private int countPrimeInFactorial(int n, int p) {
        int count = 0;
        while (n > 0) {
            n /= p;
            count += n;
        }
        return count;
    }

    // Prime factorization of k
    private Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, 1);
        }
        return factors;
    }
}
