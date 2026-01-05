class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0; // or handle as per problem's guarantee

        // Sum of first window of size k
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        long maxSum = windowSum;

        // Slide the window from index k to n - 1
        for (int i = k; i < n; i++) {
            windowSum += arr[i];       // add new element
            windowSum -= arr[i - k];   // remove element going out

            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return (int) maxSum;
    }
}
