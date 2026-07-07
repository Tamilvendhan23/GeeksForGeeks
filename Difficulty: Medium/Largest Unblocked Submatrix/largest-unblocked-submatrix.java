import java.util.*;

class Solution {
    public int largestArea(int n, int m, int k, int[][] arr) {
        // If no blocked cells, entire grid is free
        if (k == 0) {
            return n * m;
        }

        // Collect blocked rows and columns
        int[] blockedRows = new int[k];
        int[] blockedCols = new int[k];
        for (int i = 0; i < k; i++) {
            blockedRows[i] = arr[i][0];
            blockedCols[i] = arr[i][1];
        }

        // Sort them
        Arrays.sort(blockedRows);
        Arrays.sort(blockedCols);

        // Compute maximum unblocked row segment
        int maxRowGap = 0;
        // From top boundary to first blocked row
        maxRowGap = Math.max(maxRowGap, blockedRows[0] - 1);
        // Between consecutive blocked rows
        for (int i = 1; i < k; i++) {
            int gap = blockedRows[i] - blockedRows[i - 1] - 1;
            if (gap > maxRowGap) {
                maxRowGap = gap;
            }
        }
        // From last blocked row to bottom boundary
        maxRowGap = Math.max(maxRowGap, n - blockedRows[k - 1]);

        // Compute maximum unblocked column segment
        int maxColGap = 0;
        // From left boundary to first blocked column
        maxColGap = Math.max(maxColGap, blockedCols[0] - 1);
        // Between consecutive blocked columns
        for (int i = 1; i < k; i++) {
            int gap = blockedCols[i] - blockedCols[i - 1] - 1;
            if (gap > maxColGap) {
                maxColGap = gap;
            }
        }
        // From last blocked column to right boundary
        maxColGap = Math.max(maxColGap, m - blockedCols[k - 1]);

        // Largest continuous unblocked rectangle area
        return maxRowGap * maxColGap;
    }
}