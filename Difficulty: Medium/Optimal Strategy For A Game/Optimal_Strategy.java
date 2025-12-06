class Solution {
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        long[][] dp = new long[n][n];

        // len is the length of current segment
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (i == j) {
                    // Only one coin
                    dp[i][j] = arr[i];
                } else {
                    long x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                    long y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                    long z = (i <= j - 2) ? dp[i][j - 2] : 0;

                    long pickStart = arr[i] + Math.min(x, y);
                    long pickEnd   = arr[j] + Math.min(y, z);

                    dp[i][j] = Math.max(pickStart, pickEnd);
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}
