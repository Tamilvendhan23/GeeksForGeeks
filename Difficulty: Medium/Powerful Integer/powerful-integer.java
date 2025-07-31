import java.util.*;

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // TreeMap to store events (coordinate and increment)
        TreeMap<Integer, Integer> events = new TreeMap<>();
        
        // Step 1: Create events for start(+1) and end+1(-1)
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            events.put(start, events.getOrDefault(start, 0) + 1);
            events.put(end + 1, events.getOrDefault(end + 1, 0) - 1);
        }
        
        int active = 0;
        int maxPowerful = -1;
        Integer prev = null;
        
        for (Map.Entry<Integer, Integer> event : events.entrySet()) {
            int pos = event.getKey();
            if (prev != null && active >= k) {
                // All numbers in [prev, pos-1] are powerful, take the max
                maxPowerful = Math.max(maxPowerful, pos - 1);
            }
            active += event.getValue();
            prev = pos;
        }
        
        return maxPowerful;
    }
}
