class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 1, high = 2000; // Given constraints: mat[i][j] ∈ [1,2000]
        
        int desired = (n * m) / 2 + 1; // Median position for odd length

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(mat[i], mid);
            }

            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    private int countSmallerEqual(int[] row, int val) {
        // Binary search to count elements <= val in the sorted row
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] <= val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo; // lo is the count of values ≤ val
    }
}
