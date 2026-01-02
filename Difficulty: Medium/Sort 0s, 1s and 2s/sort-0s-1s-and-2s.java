class Solution {
    public void sort012(int[] arr) {
        int low = 0;              // boundary for 0s
        int mid = 0;              // current element
        int high = arr.length - 1; // boundary for 2s

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;  // 1 is in correct middle region
            } else { // arr[mid] == 2
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
                // do not increment mid here
            }
        }
    }
}
