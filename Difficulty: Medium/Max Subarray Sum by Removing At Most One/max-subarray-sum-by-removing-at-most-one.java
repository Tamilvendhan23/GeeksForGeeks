class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;

        int noDelete = arr[0];
        int oneDelete = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            int prevNoDelete = noDelete;

            noDelete = Math.max(arr[i], prevNoDelete + arr[i]);
            oneDelete = Math.max(prevNoDelete, oneDelete + arr[i]);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}