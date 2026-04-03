class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = mat.length;
        
        // Traverse anti-diagonals using sum of indices (i + j)
        for (int sum = 0; sum < 2 * n - 1; sum++) {
            // For each anti-diagonal, find all (i,j) where i + j == sum
            for (int i = Math.max(0, sum - (n - 1)); i <= Math.min(sum, n - 1); i++) {
                int j = sum - i;
                result.add(mat[i][j]);
            }
        }
        
        return result;
    }
}