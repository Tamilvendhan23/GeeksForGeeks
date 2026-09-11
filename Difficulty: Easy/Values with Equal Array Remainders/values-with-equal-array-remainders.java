class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;

        // Compute GCD of all differences |arr[i] - arr[0]|
        int g = 0;
        for (int i = 1; i < n; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }

        // If all elements are equal, infinitely many k exist
        if (g == 0) {
            return -1;
        }

        // Count all positive divisors of g
        int cnt = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                cnt++;  // i is a divisor
                if (i != g / i) {
                    cnt++;  // g/i is a different divisor
                }
            }
        }

        return cnt;
    }

    // Helper function to compute GCD
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}