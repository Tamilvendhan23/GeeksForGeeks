class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // Sort both arrays
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int maxTime = 0;
        for (int i = 0; i < mices.length; i++) {
            // Compute absolute distance for each pair
            int time = Math.abs(mices[i] - holes[i]);
            // Track the maximum distance
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}

