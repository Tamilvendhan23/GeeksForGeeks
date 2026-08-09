class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        // DP values for the bottom row
        int[] nextDp = new int[n];
        for (int j = 0; j < n; j++) {
            nextDp[j] = mat[n - 1][j];
        }

        // Process rows from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxIndex = -1;

            // Find the largest and second-largest values
            for (int j = 0; j < n; j++) {
                if (nextDp[j] > max1) {
                    max2 = max1;
                    max1 = nextDp[j];
                    maxIndex = j;
                } else if (nextDp[j] > max2) {
                    max2 = nextDp[j];
                }
            }

            int[] currentDp = new int[n];

            for (int j = 0; j < n; j++) {
                // Use the largest value unless it belongs to the same column
                int bestNext = (j == maxIndex) ? max2 : max1;
                currentDp[j] = mat[i][j] + bestNext;
            }

            nextDp = currentDp;
        }

        int answer = 0;
        for (int value : nextDp) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}