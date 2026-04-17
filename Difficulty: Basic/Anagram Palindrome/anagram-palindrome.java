class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[26];  // only lowercase letters

        // count frequency of each char
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // count how many chars have odd frequency
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // at most 1 char can have odd frequency
        return oddCount <= 1;
    }
}