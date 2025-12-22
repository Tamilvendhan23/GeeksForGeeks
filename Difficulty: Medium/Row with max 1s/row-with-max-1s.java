class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int i = 0;
        int j = m - 1;
        int ansRow = -1;

        // Start from top-right and move only left or down
        while (i < n && j >= 0) {
            if (arr[i][j] == 1) {
                // Found a 1, so this row has more 1s than previous best
                ansRow = i;
                j--;           // move left to see if there are more 1s
            } else {
                // arr[i][j] == 0, move down to next row
                i++;
            }
        }

        return ansRow;
    }
}
