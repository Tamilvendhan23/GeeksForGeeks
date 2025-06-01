import java.util.HashSet;

class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        HashSet<Integer> set = new HashSet<>();

        // Store all elements of mat2 in a HashSet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(mat2[i][j]);
            }
        }

        int count = 0;

        // For each element in mat1, check if (x - element) is in mat2's set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(x - mat1[i][j])) {
                    count++;
                }
            }
        }

        return count;
    }
}
