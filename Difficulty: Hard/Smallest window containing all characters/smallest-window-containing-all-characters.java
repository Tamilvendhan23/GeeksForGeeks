import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        // frequency of characters in p
        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqS = new int[26];
        int start = 0, minLen = Integer.MAX_VALUE, startIndex = -1;
        int count = 0; // how many chars matched

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freqS[c - 'a']++;

            // if this character is needed and not exceeded requirement
            if (freqS[c - 'a'] <= freqP[c - 'a']) {
                count++;
            }

            // if all characters matched
            if (count == p.length()) {
                // shrink from left
                while (freqS[s.charAt(start) - 'a'] > freqP[s.charAt(start) - 'a'] 
                       || freqP[s.charAt(start) - 'a'] == 0) {
                    if (freqS[s.charAt(start) - 'a'] > freqP[s.charAt(start) - 'a']) {
                        freqS[s.charAt(start) - 'a']--;
                    }
                    start++;
                }

                int windowLen = end - start + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc")); // "toprac"
        System.out.println(smallestWindow("zoomlazapzo", "oza"));    // "apzo"
        System.out.println(smallestWindow("zoom", "zooe"));          // ""
    }
}
