class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long[] sequence = new long[arr.length + 1];

        sequence[0] = s;
        long paperSum = s;

        // Generate the numbers written on the paper
        for (int i = 0; i < arr.length; i++) {
            long current = paperSum + arr[i];
            sequence[i + 1] = current;
            paperSum += current;
        }

        // Select the largest possible values first
        long remaining = x;

        for (int i = sequence.length - 1; i >= 0; i--) {
            if (sequence[i] <= remaining) {
                remaining -= sequence[i];
            }
        }

        return remaining == 0;
    }
}