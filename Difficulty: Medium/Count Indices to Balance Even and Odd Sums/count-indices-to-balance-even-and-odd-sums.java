class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] prefEven = new int[n];
        int[] prefOdd = new int[n];

        // build prefix sums
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefEven[i] = prefEven[i - 1];
                prefOdd[i] = prefOdd[i - 1];
            }
            if (i % 2 == 0) {
                prefEven[i] += arr[i];
            } else {
                prefOdd[i] += arr[i];
            }
        }

        int totalEven = prefEven[n - 1];
        int totalOdd = prefOdd[n - 1];

        int count = 0;

        for (int i = 0; i < n; i++) {
            int evenBefore = (i > 0) ? prefEven[i - 1] : 0;
            int oddBefore  = (i > 0) ? prefOdd[i - 1] : 0;

            // after removal of i
            int evenAfter = evenBefore + (totalOdd - prefOdd[i]);
            int oddAfter  = oddBefore  + (totalEven - prefEven[i]);

            if (evenAfter == oddAfter) {
                count++;
            }
        }

        return count;
    }
}
