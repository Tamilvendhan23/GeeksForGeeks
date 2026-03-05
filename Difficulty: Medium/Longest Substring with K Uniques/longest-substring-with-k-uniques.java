class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int uniques = 0;
        int maxLen = -1;
        
        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;
            if (freq[idx] == 1) {
                uniques++;
            }
            
            while (uniques > k && left <= right) {
                int leftIdx = s.charAt(left) - 'a';
                freq[leftIdx]--;
                if (freq[leftIdx] == 0) {
                    uniques--;
                }
                left++;
            }
            
            if (uniques == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}
