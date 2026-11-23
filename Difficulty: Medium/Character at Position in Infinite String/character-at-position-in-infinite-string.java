class Solution {
    public char posInfinite(String s, int pos) {
        int n = s.length();
        long len = n;          // length after step 0
        int step = 0;

        // Find the first generated string long enough to contain pos.
        while (len < pos) {
            step++;
            len = 2 * len + step;
        }

        long p = pos;

        // Undo steps from the last one back to the original string.
        while (step > 0) {
            long prevLen = (len - step) / 2;  // length before this step

            if (p <= prevLen) {
                // Position lies in the original/current left half.
                len = prevLen;
            } else if (p <= prevLen + step) {
                // Position lies in the appended '$' block.
                return '$';
            } else {
                // Position lies in reverse(previous string).
                p = p - (prevLen + step);
                p = prevLen - p + 1;  // mirror index
                len = prevLen;
            }

            step--;
        }

        return s.charAt((int) (p - 1));
    }
}