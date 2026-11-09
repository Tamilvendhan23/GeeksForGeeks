class Solution {
    int getCount(String s, int k) {
        int[] groupCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Start of a new group
            if (i == 0 || s.charAt(i - 1) != c) {
                groupCount[c - 'a']++;
            }
        }

        int ans = 0;
        for (int count : groupCount) {
            if (count == k) {
                ans++;
            }
        }

        return ans;
    }
}