import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        int maxLength = -1;
        int start = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);

            // Shrink the window if we have more than k distinct characters
            while (freqMap.size() > k) {
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                if (freqMap.get(startChar) == 0) {
                    freqMap.remove(startChar);
                }
                start++;
            }

            // Check if window is valid
            if (freqMap.size() == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}
