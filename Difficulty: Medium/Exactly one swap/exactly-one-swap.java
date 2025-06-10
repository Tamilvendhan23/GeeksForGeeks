class Solution {
    int countStrings(String s) {
            //   static int countStrings(String s) {
        int n = s.length();

        // Array to count character frequencies
        int[] map = new int[26];

        // Store total distinct strings
        int ans = 0;

        // Count valid swaps by excluding repeated characters seen so far
        for (int i = 0; i < n; i++) {
            ans += (i - map[s.charAt(i) - 'a']);
            map[s.charAt(i) - 'a']++;
        }

        // Check for any duplicate character
        for (int i = 0; i < 26; i++) {
            if (map[i] > 1) {
                ans++; 
                break;
            }
        }

        return ans;
    }
}