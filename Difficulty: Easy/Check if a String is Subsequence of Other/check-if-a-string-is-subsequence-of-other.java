class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0, j = 0;
        int n = s1.length(), m = s2.length();
        
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == n;
    }
}
