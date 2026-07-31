class Solution {
    public int countSubsets(int[] arr) {
        int MOD = 1_000_000_007;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        // Count frequency of each number
        int[] freq = new int[31];
        for (int num : arr) {
            freq[num]++;
        }
        
        // dp[mask] = number of ways to form subsets using primes in mask
        long[] dp = new long[1024]; // 2^10 = 1024
        dp[0] = 1; // base case: empty subset
        
        // Handle 1s: each 1 can be included or excluded
        for (int i = 0; i < freq[1]; i++) {
            dp[0] = (dp[0] * 2) % MOD;
        }
        
        // Process each valid number from 2 to 30
        for (int num = 2; num <= 30; num++) {
            if (freq[num] == 0) continue;
            
            // Skip numbers with repeated prime factors
            if (num % 4 == 0 || num % 9 == 0 || num % 25 == 0) continue;
            
            // Create prime mask for current number
            int mask = 0;
            for (int i = 0; i < 10; i++) {
                if (num % primes[i] == 0) {
                    mask |= (1 << i);
                }
            }
            
            // Update DP states in reverse order
            for (int state = 1023; state > 0; state--) {
                if ((state & mask) == mask) {
                    dp[state] = (dp[state] + freq[num] * dp[state ^ mask]) % MOD;
                }
            }
        }
        
        // Sum all non-empty subsets
        long result = 0;
        for (int i = 1; i < 1024; i++) {
            result = (result + dp[i]) % MOD;
        }
        
        return (int) result;
    }
}