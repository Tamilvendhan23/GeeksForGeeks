class Solution {
    int distinctSubseq(String str) {
        int mod = 1000000007;
        int n = str.length();
        
        long dp = 1;  // dp for previous (starts with empty subsequence)
        long[] last = new long[26]; // last contribution of each char
        
        for (int i = 0; i < 26; i++) last[i] = 0;
        
        for (int i = 0; i < n; i++) {
            int c = str.charAt(i) - 'a';
            
            long newDp = (dp * 2) % mod;
            
            if (last[c] != 0) {
                newDp = (newDp - last[c] + mod) % mod;
            }
            
            last[c] = dp;
            dp = newDp;
        }
        
        return (int) dp;
    }
}
