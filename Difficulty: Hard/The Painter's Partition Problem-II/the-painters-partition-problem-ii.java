class Solution {
    public int minTime(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        
        int low = 0;
        int high = 0;
        for (int length : arr) {
            low = Math.max(low, length);
            high += length;
        }
        
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    
    private boolean isPossible(int[] arr, int k, int maxTime) {
        int painters = 1;
        int currSum = 0;
        for (int length : arr) {
            if (length > maxTime) {
                return false;
            }
            if (currSum + length > maxTime) {
                painters++;
                currSum = length;
            } else {
                currSum += length;
            }
        }
        return painters <= k;
    }
}
