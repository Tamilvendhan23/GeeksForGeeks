import java.util.*;

class Solution {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        // Step 1: Sort jobs by end time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: DP array to store max profit until each job
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        // Store all end times separately for binary search
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = jobs[i][1];
        }

        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];

            // Step 3: Binary search for last non-overlapping job
            int index = binarySearch(endTimes, jobs[i][0]);
            if (index != -1) {
                profit += dp[index];
            }

            // Step 4: Choose max of including or excluding current job
            dp[i] = Math.max(dp[i - 1], profit);
        }

        return dp[n - 1];
    }

    // Binary search for the last job ending <= current start time
    private int binarySearch(int[] endTimes, int start) {
        int low = 0, high = endTimes.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (endTimes[mid] <= start) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
