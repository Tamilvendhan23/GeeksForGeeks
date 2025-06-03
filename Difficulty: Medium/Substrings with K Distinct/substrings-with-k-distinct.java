// User function Template 
class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        while (right < n) {
            // Add current character
            char rChar = s.charAt(right);
            freq.put(rChar, freq.getOrDefault(rChar, 0) + 1);
            right++;

            // Shrink window if we have more than k distinct characters
            while (freq.size() > k) {
                char lChar = s.charAt(left);
                freq.put(lChar, freq.get(lChar) - 1);
                if (freq.get(lChar) == 0) {
                    freq.remove(lChar);
                }
                left++;
            }

            // All substrings ending at right-1 with the current left are valid
            count += right - left;
        }

        return count;
    }
}
