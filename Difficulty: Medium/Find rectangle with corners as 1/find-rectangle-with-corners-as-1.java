import java.util.*;

class Solution {
    public boolean ValidCorner(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Set<String> seenPairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (mat[i][j] == 1) {
                    for (int k = j + 1; k < m; k++) {
                        if (mat[i][k] == 1) {
                            String pair = j + "," + k;
                            if (seenPairs.contains(pair)) {
                                return true;
                            }
                            seenPairs.add(pair);
                        }
                    }
                }
            }
        }
        return false;
    }
}
