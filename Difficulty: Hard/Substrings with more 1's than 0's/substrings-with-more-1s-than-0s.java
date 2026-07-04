class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        long ans = 0;

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        // Coordinate compression
        int[] all = pref.clone();
        java.util.Arrays.sort(all);

        Fenwick bit = new Fenwick(n + 1);

        for (int i = 0; i <= n; i++) {
            int idx = lowerBound(all, pref[i]) + 1;
            ans += bit.sum(idx - 1);   // count prefix sums < current
            bit.add(idx, 1);
        }

        return (int) ans;
    }

    private int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    static class Fenwick {
        int[] bit;
        Fenwick(int n) { bit = new int[n + 2]; }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
}