import java.util.Arrays;

class Solution {

    // Check if it is possible to raise the median to at least 'target' using at most k increments
    private boolean isPossible(int[] arr, int target, int k) {
        int n = arr.length;

        if (n % 2 == 1) {
            // Odd length: Increment all elements from median index to end if less than target
            for (int i = n / 2; i < n; i++) {
                if (arr[i] < target) {
                    k -= (target - arr[i]);
                    if (k < 0) return false;
                }
            }
        } else {
            // Even length: Increase both middle elements toward target
            if (arr[n / 2] <= target) {
                k -= (target - arr[n / 2]);
                k -= (target - arr[n / 2 - 1]);
            } else {
                k -= 2 * target - (arr[n / 2] + arr[n / 2 - 1]);
            }
            // For remaining elements to the right of median index, increment if needed
            for (int i = n / 2 + 1; i < n; i++) {
                if (arr[i] < target) {
                    k -= (target - arr[i]);
                    if (k < 0) return false;
                }
            }
        }
        return k >= 0;
    }

    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        // Compute initial median as floor for even length arrays
        int iniMedian = arr[n / 2];
        if (n % 2 == 0) {
            iniMedian = (arr[n / 2] + arr[n / 2 - 1]) / 2;
        }

        int low = iniMedian;
        int high = iniMedian + k;  // Max possible median after k additions
        int bestMedian = iniMedian;

        // Binary search over possible median values
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, k)) {
                bestMedian = mid;
                low = mid + 1;  // try for higher median
            } else {
                high = mid - 1; // try for lower median
            }
        }
        return bestMedian;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 3, 4, 5};
        int k1 = 3;
        System.out.println(sol.maximizeMedian(arr1, k1));  // Output: 5

        int[] arr2 = {1, 3, 6, 4, 2};
        int k2 = 10;
        System.out.println(sol.maximizeMedian(arr2, k2));  // Output: 7
    }
}
