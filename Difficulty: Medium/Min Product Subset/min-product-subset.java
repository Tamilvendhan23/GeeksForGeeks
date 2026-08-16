class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;

        // Count negatives, zeros, and track min positive, max negative
        int negCount = 0;
        int zeroCount = 0;
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        long product = 1;

        for (int num : arr) {
            if (num < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, num);
                product *= num;
            } else if (num > 0) {
                minPositive = Math.min(minPositive, num);
                product *= num;
            } else {
                zeroCount++;
            }
        }

        // Case 1: All zeros
        if (zeroCount == n) {
            return 0;
        }

        // Case 2: No negatives
        if (negCount == 0) {
            // If there are zeros, return 0 (pick subset [0])
            if (zeroCount > 0) {
                return 0;
            }
            // Otherwise return minimum positive
            return minPositive;
        }

        // Case 3: Odd number of negatives - product of all non-zeros is minimum
        if (negCount % 2 == 1) {
            return (int)product;
        }

        // Case 4: Even number of negatives - exclude the negative with smallest absolute value
        return (int)(product / maxNegative);
    }
}