class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0L;

        // Integers are up to 10^8 < 2^27, so checking bits 0..30 is safe
        for (int bit = 0; bit <= 30; bit++) {
            long countOnes = 0;

            // Count how many numbers have this bit set
            for (int num : arr) {
                if (((num >> bit) & 1) == 1) {
                    countOnes++;
                }
            }

            // Number of pairs with this bit set in both elements
            long pairs = countOnes * (countOnes - 1) / 2;

            // Add contribution of this bit to the total sum
            totalSum += pairs * (1L << bit);
        }

        return totalSum;
    }
}