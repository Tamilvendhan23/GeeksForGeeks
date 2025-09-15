class Solution {
    public boolean stringStack(String pat, String tar) {
        int i = pat.length() - 1, j = tar.length() - 1;

        while (i >= 0 && j >= 0) {
            if (pat.charAt(i) != tar.charAt(j)) {
                i -= 2; // Simulate a delete (operation allowed in pat only)
            } else {
                i--;
                j--;
            }
        }
        return j < 0; // Every character in tar has been matched
    }
}
