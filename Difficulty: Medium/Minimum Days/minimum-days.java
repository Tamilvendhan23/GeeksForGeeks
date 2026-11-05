class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        int[] day = new int[n]; // day[x] = day on which index x becomes '?'

        for (int i = 0; i < n; i++) {
            day[p[i]] = i + 1;
        }

        int ans = 0;

        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                // One of these two must be replaced by '?'
                ans = Math.max(ans, Math.min(day[i], day[i + 1]));
            }
        }

        return ans;
    }
}