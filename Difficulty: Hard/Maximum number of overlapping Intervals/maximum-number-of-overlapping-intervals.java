class Solution {
    public static int overlapInt(int[][] arr) {
        int n = arr.length;
        // Create events: {time, type} where type=0 for start, 1 for end
        int[][] events = new int[2 * n][2];
        int idx = 0;
        for (int[] interval : arr) {
            events[idx][0] = interval[0];  // start
            events[idx++][1] = 0;
            events[idx][0] = interval[1];  // end
            events[idx++][1] = 1;
        }
        
        // Sort by time asc, then start before end if time equal
        java.util.Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int maxOverlap = 0;
        int current = 0;
        for (int[] event : events) {
            if (event[1] == 0) {  // start
                current++;
            } else {  // end
                current--;
            }
            maxOverlap = Math.max(maxOverlap, current);
        }
        return maxOverlap;
    }
}
