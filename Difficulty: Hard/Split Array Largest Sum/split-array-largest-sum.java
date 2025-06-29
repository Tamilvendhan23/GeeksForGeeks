class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        for (int num : arr) {
            low = Math.max(low, num);  // minimum possible max sum
            high += num;               // maximum possible max sum
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] arr, int k, int maxAllowedSum) {
        int count = 1; // start with 1 subarray
        int currSum = 0;

        for (int num : arr) {
            if (currSum + num > maxAllowedSum) {
                count++;
                currSum = num;
                if (count > k) return false;
            } else {
                currSum += num;
            }
        }

        return true;
    }
}
