class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1); // numbers missing up to arr[mid]

            if (missing < k) {
                // need more missing numbers -> go right
                low = mid + 1;
            } else {
                // already have >= k missing numbers -> go left
                high = mid - 1;
            }
        }

        // low is the count of elements in arr that are <= the answer
        return low + k;
    }
}
