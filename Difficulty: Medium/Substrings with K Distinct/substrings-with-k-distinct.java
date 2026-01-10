class Solution {
    private int atMostK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int distinct = 0;
        int left = 0;
        long count = 0;  // Use long to avoid overflow
        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;
            if (freq[idx] == 1) distinct++;
            
            while (distinct > k && left <= right) {
                int leftIdx = s.charAt(left) - 'a';
                freq[leftIdx]--;
                if (freq[leftIdx] == 0) distinct--;
                left++;
            }
            
            count += (right - left + 1L);
        }
        return (int) count;
    }
    
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostK(s, k) - atMostK(s, k - 1);
    }
}
