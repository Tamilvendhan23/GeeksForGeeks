class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int[] left = new int[n];   // nearest router to the left
        int[] right = new int[n];  // nearest router to the right
        
        // Initialize with sentinel values
        for (int i = 0; i < n; i++) {
            left[i] = -1_000_000_000;
            right[i] = 1_000_000_000;
        }
        
        // Find nearest router to the left for each position
        int cur = -1_000_000_000;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur = i;
            }
            left[i] = cur;
        }
        
        // Find nearest router to the right for each position
        cur = 1_000_000_000;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cur = i;
            }
            right[i] = cur;
        }
        
        // Check if each room is within range x of at least one router
        for (int i = 0; i < n; i++) {
            if (Math.abs(i - left[i]) > x && Math.abs(i - right[i]) > x) {
                return false;
            }
        }
        
        return true;
    }
}