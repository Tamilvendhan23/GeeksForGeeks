class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // If no people need to be seated, return true
        if (k == 0) return true;
        
        int availableSeats = 0;
        int n = seats.length;
        
        for (int i = 0; i < n; i++) {
            // Get previous seat value (0 if at index 0)
            int prev = (i == 0) ? 0 : seats[i - 1];
            // Get next seat value (0 if at last index)
            int next = (i == n - 1) ? 0 : seats[i + 1];
            
            // Check if current seat is available (current, prev, and next are all 0)
            if (seats[i] == 0 && prev == 0 && next == 0) {
                availableSeats++;
                // If we found enough seats, return true
                if (availableSeats == k) {
                    return true;
                }
                // Skip next seat since no one can sit there (adjacent constraint)
                i++;
            }
        }
        
        return false;
    }
}