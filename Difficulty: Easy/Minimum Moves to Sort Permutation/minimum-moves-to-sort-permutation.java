class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        // Store position of each value
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        // Find longest sequence where positions are increasing
        int maxLen = 0;
        int currentLen = 0;
        int prevPos = -1;

        for (int i = 1; i <= n; i++) {
            if (pos[i] > prevPos) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            prevPos = pos[i];
            maxLen = Math.max(maxLen, currentLen);
        }

        return n - maxLen;
    }
}