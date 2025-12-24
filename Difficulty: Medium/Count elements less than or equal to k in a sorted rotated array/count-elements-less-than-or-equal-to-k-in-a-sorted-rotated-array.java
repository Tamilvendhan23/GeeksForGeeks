class Solution {

    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr);

        int count = 0;

        // Left sorted part [0 ... pivot-1]
        if (pivot > 0) {
            count += countInRange(arr, 0, pivot - 1, x);
        }

        // Right sorted part [pivot ... n-1]
        count += countInRange(arr, pivot, n - 1, x);

        return count;
    }

    // Find index of minimum element
    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Correct binary search count
    private int countInRange(int[] arr, int L, int R, int x) {
        int low = L, high = R;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (ans == -1) return 0;
        return ans - L + 1;
    }
}
