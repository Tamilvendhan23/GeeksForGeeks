class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        int candidate = 0;

        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // candidate knows i => candidate cannot be celebrity
                candidate = i;
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know i, and everyone (i) should know candidate
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
