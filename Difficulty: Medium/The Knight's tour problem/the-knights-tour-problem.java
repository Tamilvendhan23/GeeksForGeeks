import java.util.ArrayList;

class Solution {
    private static final int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        int[][] board = new int[n][n];
        // Initialize the board with -1 denoting unvisited cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }
        // Starting position
        board[0][0] = 0;

        if (solveKTUtil(0, 0, 1, board, n)) {
            // Convert board to ArrayList<ArrayList<Integer>>
            return convertToArrayList(board, n);
        } else {
            // Return empty list if no solution
            return new ArrayList<>();
        }
    }

    private boolean solveKTUtil(int x, int y, int movei, int[][] board, int n) {
        if (movei == n * n) {
            return true; // All cells visited
        }

        for (int k = 0; k < 8; k++) {
            int nextX = x + xMoves[k];
            int nextY = y + yMoves[k];
            if (isSafe(nextX, nextY, board, n)) {
                board[nextX][nextY] = movei;
                if (solveKTUtil(nextX, nextY, movei + 1, board, n)) {
                    return true;
                } else {
                    // Backtracking
                    board[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int x, int y, int[][] board, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }

    private ArrayList<ArrayList<Integer>> convertToArrayList(int[][] board, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(board[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
