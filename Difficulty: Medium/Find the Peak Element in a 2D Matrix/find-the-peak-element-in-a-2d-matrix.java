import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0, right = m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Find row index of maximum element in column mid
            int maxRow = 0;
            for (int i = 1; i < n; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int midVal = mat[maxRow][mid];
            int leftVal = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int rightVal = (mid + 1 < m) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

            // Check if it's a peak considering left and right
            if (midVal >= leftVal && midVal >= rightVal) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(maxRow);
                ans.add(mid);
                return ans;
            } else if (leftVal > midVal) {
                // Peak lies towards left side
                right = mid - 1;
            } else {
                // Peak lies towards right side
                left = mid + 1;
            }
        }

        // This line should not be reached if input satisfies constraints
        return new ArrayList<>();
    }
}
