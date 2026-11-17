class Solution {
    public boolean findPattern(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            // Count consecutive x's
            int xCount = 0;
            while (i < n && s.charAt(i) == 'x') {
                xCount++;
                i++;
            }

            // A valid block must begin with at least one x
            if (xCount == 0) {
                return false;
            }

            // Count consecutive y's
            int yCount = 0;
            while (i < n && s.charAt(i) == 'y') {
                yCount++;
                i++;
            }

            // Each x-run must be followed by an equal y-run
            if (xCount != yCount) {
                return false;
            }
        }

        return true;
    }
}