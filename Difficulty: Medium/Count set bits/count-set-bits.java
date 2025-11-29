class Solution {
    public static int countSetBits(int n) {
        // We work from 1 to n, so increment for the known formula that uses 0..n
        n++; 
        
        int count = 0;
        int powerOf2 = 1; // 2^0

        while (powerOf2 <= n) {
            int totalPairs = n / (powerOf2 << 1);      // number of full (0..1) blocks
            count += totalPairs * powerOf2;            // full blocks contribution

            int remainder = n % (powerOf2 << 1);       // leftover part
            if (remainder > powerOf2) {
                count += remainder - powerOf2;         // extra ones in leftover
            }

            powerOf2 <<= 1;                            // move to next bit
        }
        return count;
    }
}
