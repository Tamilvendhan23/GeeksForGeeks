class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / m;
            int midCol = mid % m;
            int midVal = mat[midRow][midCol];

            if (midVal == x) return true;

            // Get real start and end
            int leftRow = left / m, leftCol = left % m;
            int rightRow = right / m, rightCol = right % m;
            int leftVal = mat[leftRow][leftCol];
            int rightVal = mat[rightRow][rightCol];

            // Left half is sorted
            if (leftVal <= midVal) {
                if (x >= leftVal && x < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (x > midVal && x <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
