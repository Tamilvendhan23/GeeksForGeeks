class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        
        // Create array of [absolute_difference, index]
        int[][] diff = new int[n][2];
        for (int i = 0; i < n; i++) {
            diff[i][0] = Math.abs(a[i] - b[i]);
            diff[i][1] = i;
        }
        
        // Sort by difference in descending order
        Arrays.sort(diff, (c, d) -> Integer.compare(d[0], c[0]));
        
        int ans = 0;
        int i = 0;
        
        // Assign tasks while both machines have capacity
        while (i < n && x > 0 && y > 0) {
            int index = diff[i][1];
            if (a[index] >= b[index]) {
                ans += a[index];
                x--;
            } else {
                ans += b[index];
                y--;
            }
            i++;
        }
        
        // Remaining tasks go to Machine A if B is full
        while (i < n && x > 0) {
            int index = diff[i][1];
            ans += a[index];
            x--;
            i++;
        }
        
        // Remaining tasks go to Machine B if A is full
        while (i < n && y > 0) {
            int index = diff[i][1];
            ans += b[index];
            y--;
            i++;
        }
        
        return ans;
    }
}