import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                if (mat[r][c] != word.charAt(0)) continue;

                boolean found = false;

                // Try every direction from this starting cell
                for (int d = 0; d < 8 && !found; d++) {
                    int nr = r;
                    int nc = c;
                    int k;

                    for (k = 1; k < word.length(); k++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= m ||
                            mat[nr][nc] != word.charAt(k)) {
                            break;
                        }
                    }

                    if (k == word.length()) {
                        found = true;
                    }
                }

                // The nested row/column traversal already gives lexicographic order.
                if (found) {
                    ArrayList<Integer> position = new ArrayList<>();
                    position.add(r);
                    position.add(c);
                    ans.add(position);
                }
            }
        }

        return ans;
    }
}