class Solution {
    public int countMinOperations(int[] arr) {
        int n = arr.length;
        int ops = 0;

        while (true) {
            // Count zeros and find first odd element
            int zeroCount = 0;
            int i = 0;
            for (; i < n; i++) {
                if (arr[i] == 0) {
                    zeroCount++;
                } else if ((arr[i] & 1) == 1) { // odd
                    break;
                }
            }

            // If all are zero, we are done
            if (zeroCount == n) {
                return ops;
            }

            // If all are even (i reached n), divide all by 2
            if (i == n) {
                for (int j = 0; j < n; j++) {
                    arr[j] >>= 1; // divide by 2
                }
                ops++;
            } else {
                // Make all odd elements even by decrementing them
                for (int j = i; j < n; j++) {
                    if ((arr[j] & 1) == 1) {
                        arr[j]--;
                        ops++;
                    }
                }
            }
        }
    }
}