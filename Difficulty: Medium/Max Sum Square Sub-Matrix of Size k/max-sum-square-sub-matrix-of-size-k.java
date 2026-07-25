class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[][] pre = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                int sum = pre[i][j]
                        - pre[i - k][j]
                        - pre[i][j - k]
                        + pre[i - k][j - k];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}