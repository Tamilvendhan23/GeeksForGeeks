class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int count = 0;
        int rightMin = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < rightMin && arr[i] > (i > 0 ? leftMax[i - 1] : Integer.MIN_VALUE)) {
                count++;
            }
            rightMin = Math.min(rightMin, arr[i]);
        }

        return count;
    }
}