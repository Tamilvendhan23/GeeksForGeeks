class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] count = new int[n + 1];

        // count[k] = number of roll operations of length k
        for (int r : roll) {
            count[r]++;
        }

        StringBuilder sb = new StringBuilder(n);
        int total = 0;

        // Traverse from right to left:
        // position i is affected by all rolls with length >= i + 1
        for (int i = n - 1; i >= 0; i--) {
            total += count[i + 1];

            int shift = total % 26;
            char c = s.charAt(i);
            char rolled = (char) ('a' + (c - 'a' + shift) % 26);

            sb.append(rolled);
        }

        return sb.reverse().toString();
    }
}