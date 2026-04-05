class Solution {
    public int totalWays(int[] arr, int target) {
        int n = arr.length;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (Math.abs(target) > totalSum || (totalSum - target) % 2 != 0) {
            return 0;
        }
        
        int negTarget = (totalSum - target) / 2;
        int[][] dp = new int[n + 1][negTarget + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= negTarget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        
        return dp[n][negTarget];
    }
}