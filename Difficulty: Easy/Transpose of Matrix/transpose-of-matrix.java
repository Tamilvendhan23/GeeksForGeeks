class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Initialize result matrix of size n x n
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }
        
        // Fill transpose: result[j][i] = mat[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.get(j).set(i, mat[i][j]);
            }
        }
        
        return result;
    }
}
