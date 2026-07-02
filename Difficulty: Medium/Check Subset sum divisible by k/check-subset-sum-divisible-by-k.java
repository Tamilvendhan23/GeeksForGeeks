class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] next = dp.clone();
            int rem = num % k;

            next[rem] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next[(r + rem) % k] = true;
                }
            }

            dp = next;
            if (dp[0]) return true;
        }

        return false;
    }
}