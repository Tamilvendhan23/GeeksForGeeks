class Solution {
    public int searchInsertK(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == k) {
                return mid;              // found exact element
            } else if (arr[mid] < k) {
                low = mid + 1;           // go right
            } else {
                high = mid - 1;          // go left
            }
        }
        
        // when not found, low is the correct insert position
        return low;
    }
}
