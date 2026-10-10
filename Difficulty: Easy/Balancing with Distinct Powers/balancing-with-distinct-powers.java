class Solution {
    public boolean balancePan(int a, int b) {
        long x = b;
        long base = a;

        while (x > 0) {
            long rem = x % base;

            if (rem == 0 || rem == 1) {
                x /= base;
            } else if (rem == base - 1) {
                // Treat this digit as -1 and carry 1
                x = x / base + 1;
            } else {
                return false;
            }
        }

        return true;
    }
}