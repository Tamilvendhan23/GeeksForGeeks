class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int total = 0;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                total += mat[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        int targetTotal = n * maxSum;
        int ops = targetTotal - total;
        return ops;
    }
}
