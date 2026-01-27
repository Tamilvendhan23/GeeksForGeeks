class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        if (n == 0) return false;
        int m = mat[0].length;
        
        // Try starting from every cell that matches first char
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, int x, int y, int idx, String word) {
        // Base case: found entire word
        if (idx == word.length()) {
            return true;
        }
        
        // Out of bounds or mismatch
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || 
            board[x][y] != word.charAt(idx)) {
            return false;
        }
        
        // Mark as visited and backtrack
        char temp = board[x][y];
        board[x][y] = '#';
        
        // Explore 4 directions
        boolean found = dfs(board, x + 1, y, idx + 1, word) ||
                        dfs(board, x - 1, y, idx + 1, word) ||
                        dfs(board, x, y + 1, idx + 1, word) ||
                        dfs(board, x, y - 1, idx + 1, word);
        
        // Restore for backtracking
        board[x][y] = temp;
        
        return found;
    }
}
