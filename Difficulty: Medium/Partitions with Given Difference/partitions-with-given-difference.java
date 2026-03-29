class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr) sum += x;

        // Edge: impossible if sum < diff or sum+diff is odd
        if (sum < diff || (sum + diff) % 2 != 0) return 0;

        int target = (sum + diff) / 2;

        // dp[j] = number of ways to get sum j
        int[] dp = new int[target + 1];
        dp[0] = 1;  // one way to get sum 0

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            for (int j = target; j >= val; j--) {
                dp[j] += dp[j - val];
            }
        }

        return dp[target];
    }
}