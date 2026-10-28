class Solution {
    public char nthCharacter(int n) {
        long len = 1;        // current number length
        long count = 9;      // how many numbers have this length
        long start = 1;      // first number with this length

        // Skip complete digit-length groups
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // Find the exact number containing the nth character
        long number = start + (n - 1) / len;

        // Find which digit of that number is needed
        int digitIndex = (int) ((n - 1) % len);

        return String.valueOf(number).charAt(digitIndex);
    }
}