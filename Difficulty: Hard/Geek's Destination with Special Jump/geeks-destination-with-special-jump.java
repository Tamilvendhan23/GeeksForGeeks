class Solution {
    static final int MOD = 1_000_000_007;

    public int minTime(int a, int b, int d, int l, int r) {
        long lowX = d - r;   // corresponding x for j = r
        long highX = d - l;  // corresponding x for j = l

        long normalTime = earliestTime(d, a, b);

        // Largest x for which jumping is at least as good:
        // T(x) + 1 <= T(d)
        long lo = lowX, hi = highX, cutoff = lowX - 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (earliestTime(mid, a, b) + 1 <= normalTime) {
                cutoff = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        long ans = 0;

        if (cutoff >= lowX) {
            // Sum of (T(x) + 1) for x in [lowX, cutoff]
            long jumpSum = prefix(cutoff, a, b) - prefix(lowX - 1, a, b);
            jumpSum += cutoff - lowX + 1;

            // Sum of T(d) for x in [cutoff + 1, highX]
            long normalCount = highX - cutoff;
            long normalSum = normalCount % MOD * (normalTime % MOD) % MOD;

            ans = (jumpSum % MOD + normalSum) % MOD;
        } else {
            long normalCount = highX - lowX + 1;
            ans = normalCount % MOD * (normalTime % MOD) % MOD;
        }

        return (int) ((ans % MOD + MOD) % MOD);
    }

    private long earliestTime(long x, int a, int b) {
        if (x <= a) {
            return x;
        }

        long step = a - b;
        long cycles = (x - a + step - 1) / step; // ceil((x-a)/step)

        return x + 2L * b * cycles;
    }

    private long prefix(long n, int a, int b) {
        if (n <= 0) {
            return 0;
        }

        if (n <= a) {
            return n * (n + 1) / 2;
        }

        long m = n - a;
        long step = a - b;

        long full = m / step;
        long rem = m % step;

        long ceilSum = step * full * (full + 1) / 2 + rem * (full + 1);

        long firstPart = a * (a + 1) / 2;
        long linearPart = m * a + m * (m + 1) / 2;
        long cyclePart = 2L * b * ceilSum;

        return firstPart + linearPart + cyclePart;
    }
}