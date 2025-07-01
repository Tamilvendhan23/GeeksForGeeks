class Solution {
    public int substrCount(String s, int k) {
        if (s == null || s.length() < k) return 0;
        
        int count = 0;
        int[] freq = new int[26];
        int distinctCount = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the window
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinctCount++;
            }
            freq[s.charAt(right) - 'a']++;
            
            // Shrink the window if size exceeds k
            if (right - left + 1 > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }
            
            // When window size is exactly k, check the condition
            if (right - left + 1 == k && distinctCount == k - 1) {
                count++;
            }
        }
        
        return count;
    }
}