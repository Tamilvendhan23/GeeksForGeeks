class Solution {
    public long sumXOR(int[] arr) {
        long sum = 0;
        int n = arr.length;
        for (int i = 0; i < 32; i++) {
            int oc = 0; // count of ones
            for (int num : arr) {
                if (((num >> i) & 1) == 1) {  // Fixed: explicit comparison to 1
                    oc++;
                }
            }
            int zc = n - oc;
            sum += (long) oc * zc * (1L << i);
        }
        return sum;
    }
}