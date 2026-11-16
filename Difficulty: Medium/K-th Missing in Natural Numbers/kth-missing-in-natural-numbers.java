class Solution {
    public int findKthSmall(int[] arr, int k) {
        // Sort in place: O(1) auxiliary space
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Find the smallest index where missing count >= k
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Missing positive numbers up to arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 'left' existing numbers occur before the k-th missing number
        return left + k;
    }
}