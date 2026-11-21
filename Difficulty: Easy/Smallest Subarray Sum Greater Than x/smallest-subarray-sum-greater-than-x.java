class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int start = 0;
        long sum = 0;
        int minLen = n + 1;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            while (sum > x) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        return minLen == n + 1 ? 0 : minLen;
    }
}