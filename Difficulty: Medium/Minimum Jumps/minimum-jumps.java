class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        // If first element is 0 and array size > 1, we can't move
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0]; 
        int steps = arr[0];    
        int jumps = 1;         

        for (int i = 1; i < n; i++) {
            // If we reached the end
            if (i == n - 1) return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            // If no more steps left
            if (steps == 0) {
                jumps++;

                // If current index >= maxReach, we are stuck
                if (i >= maxReach) return -1;

                // Re-initialize steps for the next jump
                steps = maxReach - i;
            }
        }
        return -1;
    }
}
