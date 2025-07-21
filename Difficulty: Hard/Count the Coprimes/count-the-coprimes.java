import java.util.*;

class Solution {
    int cntCoprime(int[] arr) {
        int maxElement = 0;
        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        
        int[] freq = new int[maxElement + 1];
        for (int num : arr) {
            freq[num]++;
        }
        
        int[] count = new int[maxElement + 1];
        for (int d = 1; d <= maxElement; d++) {
            for (int multiple = d; multiple <= maxElement; multiple += d) {
                count[d] += freq[multiple];
            }
        }
        
        int[] mobius = new int[maxElement + 1];
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[maxElement + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int p = 2; p <= maxElement; p++) {
            if (isPrime[p]) {
                for (int multiple = p; multiple <= maxElement; multiple += p) {
                    isPrime[multiple] = (multiple == p) ? isPrime[multiple] : false;
                    mobius[multiple] *= -1;
                }
                int pSquare = p * p;
                for (int multiple = pSquare; multiple <= maxElement; multiple += pSquare) {
                    mobius[multiple] = 0;
                }
            }
        }
        
        long nonCoprimePairs = 0;
        for (int d = 2; d <= maxElement; d++) {
            if (mobius[d] != 0) {
                long cnt = count[d];
                nonCoprimePairs += mobius[d] * cnt * (cnt - 1) / 2;
            }
        }
        
        long totalPairs = (long) arr.length * (arr.length - 1) / 2;
        return (int) (totalPairs + nonCoprimePairs);
    }
}