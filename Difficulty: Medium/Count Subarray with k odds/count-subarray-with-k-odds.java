class Solution {
    public int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    // count subarrays with at most x odd numbers
    private int atMost(int[] arr, int x) {
        int n = arr.length;
        int left = 0;
        int oddCount = 0;
        int res = 0;

        for (int right = 0; right < n; right++) {
            // include arr[right]
            if ((arr[right] & 1) == 1) {
                oddCount++;
            }

            // shrink while odds exceed x
            while (oddCount > x) {
                if ((arr[left] & 1) == 1) {
                    oddCount--;
                }
                left++;
            }

            // all subarrays ending at right and starting from [left..right]
            res += right - left + 1;
        }

        return res;
    }
}
