class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int i = 0, j = 0;
        int dir = 0;  // 0: right, 1: down, 2: left, 3: up
        
        while (true) {
            // Update direction: if cell is 1, turn right (clockwise)
            dir = (dir + mat[i][j]) % 4;
            
            // If cell is 1, update it to 0
            if (mat[i][j] == 1) {
                mat[i][j] = 0;
            }
            
            // Move in the current direction
            if (dir == 0) {  // right
                j++;
            } else if (dir == 1) {  // down
                i++;
            } else if (dir == 2) {  // left
                j--;
            } else if (dir == 3) {  // up
                i--;
            }
            
            // Check if we've exited the matrix
            if (i < 0) {
                i++;
                break;
            } else if (i == n) {
                i--;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (j == m) {
                j--;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(i);
        result.add(j);
        return result;
    }
}