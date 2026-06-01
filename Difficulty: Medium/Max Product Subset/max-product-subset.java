class Solution {
    public int findMaxProduct(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return arr[0];

        long MOD = 1000000007L;

        int negCount = 0;
        int zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            } else if (x < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, x);
            }
        }

        if (zeroCount == n)
            return 0;

        if (negCount == 1 && zeroCount + negCount == n)
            return 0;

        long ans = 1;
        boolean removed = false;

        for (int x : arr) {

            if (x == 0)
                continue;

            if ((negCount & 1) == 1 &&
                x == maxNeg &&
                !removed) {
                removed = true;
                continue;
            }

            long val = x;

            if (val < 0)
                val = (val + MOD) % MOD;

            ans = (ans * val) % MOD;
        }

        return (int) ans;
    }
}