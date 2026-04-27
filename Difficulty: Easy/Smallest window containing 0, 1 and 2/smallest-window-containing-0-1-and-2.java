class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int res = Integer.MAX_VALUE;

        // Last seen indices of '0','1','2'
        int zeroIndex = -1;
        int oneIndex  = -1;
        int twoIndex  = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') zeroIndex = i;
            else if (c == '1') oneIndex = i;
            else if (c == '2') twoIndex = i;

            // If we have seen all three characters
            if (zeroIndex != -1 && oneIndex != -1 && twoIndex != -1) {
                int left  = Math.min(Math.min(zeroIndex, oneIndex), twoIndex);
                int right = Math.max(Math.max(zeroIndex, oneIndex), twoIndex);
                res = Math.min(res, right - left + 1);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}