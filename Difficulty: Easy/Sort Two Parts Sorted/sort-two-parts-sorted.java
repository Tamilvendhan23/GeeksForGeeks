class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;

        // Find the break point: first index where order breaks.
        int breakPoint = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                breakPoint = i + 1;
                break;
            }
        }

        // Already fully sorted, or one part is empty.
        if (breakPoint == -1) return;

        int[] temp = new int[n];
        int i = 0, j = breakPoint, k = 0;

        // Merge [0, breakPoint) and [breakPoint, n)
        while (i < breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < breakPoint) temp[k++] = arr[i++];
        while (j < n) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, 0, n);
    }
}