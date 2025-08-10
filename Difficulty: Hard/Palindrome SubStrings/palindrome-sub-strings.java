class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;
        // Expand around center for each possible center
        for (int center = 0; center < n; center++) {
            // Odd length palindromes
            int left = center, right = center;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= 2) count++;
                left--;
                right++;
            }
            // Even length palindromes
            left = center;
            right = center + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= 2) count++;
                left--;
                right++;
            }
        }
        return count;
    }
}