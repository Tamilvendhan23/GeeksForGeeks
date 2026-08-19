import java.util.Arrays;

class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        long count = countAtMost(arr, r) - countAtMost(arr, l - 1);

        // The method signature requires int.
        return (int) count;
    }

    // Counts index triplets i < j < k whose sum is <= limit.
    private long countAtMost(int[] arr, long limit) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= limit) {
                    /*
                     * Since the array is sorted, all pairs:
                     * (left, left + 1), ..., (left, right)
                     * also produce a sum <= limit.
                     */
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}