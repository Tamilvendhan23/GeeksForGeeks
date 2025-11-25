class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int xorResult = 0;

        for (int i = 0; i < n; i++) {
            long count = (long)(i + 1) * (n - i);
            if (count % 2 == 1) {
                xorResult ^= arr[i];
            }
        }

        return xorResult;
    }
}
