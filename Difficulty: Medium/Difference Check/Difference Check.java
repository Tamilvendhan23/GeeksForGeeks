import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] secondsArr = new int[n];

        // Convert each time string to total seconds past midnight
        for (int i = 0; i < n; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            secondsArr[i] = h * 3600 + m * 60 + s;
        }

        // Sort the seconds array
        Arrays.sort(secondsArr);

        // Find minimum difference between consecutive times
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, secondsArr[i] - secondsArr[i-1]);
        }

        // Check difference between last and first (because of wrap-around)
        int wrapDiff = 24 * 3600 - (secondsArr[n-1] - secondsArr[0]);
        minDiff = Math.min(minDiff, wrapDiff);

        return minDiff;
    }
}
