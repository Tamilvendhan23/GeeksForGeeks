class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        // Length of string must be a multiple of k
        if (n % k != 0) {
            return false;
        }
        
        // Map to store substrings of length k and their counts
        HashMap<String, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < n; i += k) {
            String substr = s.substring(i, i + k);
            mp.put(substr, mp.getOrDefault(substr, 0) + 1);
        }
        
        // If string is already a repetition of k substrings, return true
        if (mp.size() == 1) {
            return true;
        }
        
        // If number of distinct substrings is not 2, then not possible
        if (mp.size() != 2) {
            return false;
        }
        
        // One of the two distinct substrings must appear exactly once
        // Either it appears once, or it appears n/k-1 times (making the other appear once)
        for (int count : mp.values()) {
            if (count == 1 || count == (n / k - 1)) {
                return true;
            }
        }
        
        return false;
    }
}