class Solution {
    public int smallestDivisor(int[] arr, int k) {
        int left = 1, right = getMax(arr);
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (computeSum(arr, mid) <= k) {
                ans = mid; // possible answer
                right = mid - 1; // try smaller
            } else {
                left = mid + 1; // try larger
            }
        }
        return ans;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int computeSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; // efficient way to do ceil
        }
        return sum;
    }
}