class Solution {
    static boolean canAttend(int[][] arr) {
        if (arr.length <= 1) return true;
        
        // Sort meetings by start time
        java.util.Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Check adjacent meetings for overlap
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1][1] > arr[i][0]) {
                return false;
            }
        }
        
        return true;
    }
}
