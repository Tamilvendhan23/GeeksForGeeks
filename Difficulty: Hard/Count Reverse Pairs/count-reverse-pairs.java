class Solution {
    public int countRevPairs(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(arr, left, mid) + mergeSortAndCount(arr, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge step
        merge(arr, left, mid, right);
        return count;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}
