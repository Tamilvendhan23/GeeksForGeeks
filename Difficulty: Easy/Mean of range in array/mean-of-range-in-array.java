class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            long sum = prefix[r + 1] - prefix[l];
            int count = r - l + 1;
            result.add((int) (sum / count));
        }
        return result;
    }
}