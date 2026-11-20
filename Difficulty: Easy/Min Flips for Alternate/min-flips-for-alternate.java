class Solution {
    public int minFlips(String s) {
        int flipsForStart0 = 0; // target: 0101...
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected) {
                flipsForStart0++;
            }
        }

        // Flips needed for target 1010... are the remaining positions.
        int flipsForStart1 = n - flipsForStart0;

        return Math.min(flipsForStart0, flipsForStart1);
    }
}