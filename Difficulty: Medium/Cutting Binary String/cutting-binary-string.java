class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -2); // -2 means uncomputed, -1 means impossible

        int res = dfs(0, s, dp);
        return res;
    }

    private int dfs(int i, String s, int[] dp) {
        if (i == s.length()) return 0;
        if (dp[i] != -2) return dp[i];

        int minCuts = Integer.MAX_VALUE;

        for (int j = i + 1; j <= s.length(); j++) {
            String part = s.substring(i, j);
            if (isPowerOf5(part)) {
                int result = dfs(j, s, dp);
                if (result != -1) {
                    minCuts = Math.min(minCuts, 1 + result);
                }
            }
        }

        dp[i] = (minCuts == Integer.MAX_VALUE) ? -1 : minCuts;
        return dp[i];
    }

    private boolean isPowerOf5(String bin) {
        // Skip leading zeros
        if (bin.charAt(0) == '0') return false;

        long num = Long.parseLong(bin, 2);

        if (num == 0) return false;

        // Check if number is a power of 5
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
