class Solution {
    static final int MOD = 1_000_000_007;

    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;

        int[] freq = new int[n + 2];
        for (int x : arr) {
            freq[x]++;
        }

        // suffixGreater[i] = number of elements strictly greater than i
        int[] suffixGreater = new int[n + 2];
        for (int i = n; i >= 0; i--) {
            suffixGreater[i] = suffixGreater[i + 1] + freq[i];
        }

        // Precompute powers of 2
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long ans = 0;
        long waysToIncludeAllBelow = 1; // product of (2^freq[v] - 1) for v < m

        for (int m = 0; m <= r; m++) {
            if (m > 0) {
                if (freq[m - 1] == 0) {
                    waysToIncludeAllBelow = 0;
                } else {
                    waysToIncludeAllBelow =
                        (waysToIncludeAllBelow * ((pow2[freq[m - 1]] - 1 + MOD) % MOD)) % MOD;
                }
            }

            if (m >= l) {
                long freeChoices = pow2[suffixGreater[m + 1]];
                ans = (ans + waysToIncludeAllBelow * freeChoices) % MOD;
            }

            // Once product becomes 0, it remains 0 for all larger MEX values
            if (waysToIncludeAllBelow == 0) break;
        }

        return (int) ans;
    }
}