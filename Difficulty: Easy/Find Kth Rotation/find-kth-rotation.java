class Solution {
    public int findKRotation(int arr[]) {
        int low = 0, high = arr.length - 1;
        int n = arr.length;

        while (low <= high) {
            // already sorted → no rotation
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            // minimum element found
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }

            // left part sorted → pivot on right
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } 
            // right part sorted → pivot on left
            else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
