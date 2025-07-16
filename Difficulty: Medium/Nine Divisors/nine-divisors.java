import java.util.*;

class Solution {
    public static int countNumbers(int n) {
        // Sieve to generate all primes up to sqrt(n)
        int limit = (int)Math.sqrt(n) + 1;
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Collect all primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;

        // Case 1: p^8
        for (int p : primes) {
            long num = 1;
            for (int i = 0; i < 8; i++) num *= p;
            if (num <= n) count++;
            else break;
        }

        // Case 2: p^2 * q^2
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = (long)primes.get(i) * primes.get(i);
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                long q2 = (long)primes.get(j) * primes.get(j);
                if (p2 * q2 <= n) count++;
                else break;
            }
        }

        return count;
    }
}
