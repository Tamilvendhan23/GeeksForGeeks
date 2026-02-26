class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map1[c1] != map2[c2]) {
                return false;
            }
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }
        return true;
    }
}
