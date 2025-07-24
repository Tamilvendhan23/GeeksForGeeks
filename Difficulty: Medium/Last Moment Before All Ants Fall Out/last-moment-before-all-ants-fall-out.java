class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;

        // Ants moving left fall off at their current position
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // Ants moving right fall off at n - position
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}
