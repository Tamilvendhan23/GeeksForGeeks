class Solution {
    public static String minWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        
        if (len1 < len2) return "";
        
        int[] countP = new int[26];
        int[] countWindow = new int[26];
        
        // Count required characters from p
        for (char ch : p.toCharArray()) {
            countP[ch - 'a']++;
        }
        
        int required = p.length(); // Total characters needed
        int formed = 0; // Characters currently satisfied
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        
        for (int right = 0; right < len1; right++) {
            char rightCh = s.charAt(right);
            countWindow[rightCh - 'a']++;
            
            // If we've included one more required character
            if (countP[rightCh - 'a'] > 0 && countWindow[rightCh - 'a'] <= countP[rightCh - 'a']) {
                formed++;
            }
            
            // Try to contract the window from the left
            while (formed == required && left <= right) {
                char leftCh = s.charAt(left);
                
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }
                
                countWindow[leftCh - 'a']--;
                if (countP[leftCh - 'a'] > 0 && countWindow[leftCh - 'a'] < countP[leftCh - 'a']) {
                    formed--;
                }
                left++;
            }
        }
        
        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
}
