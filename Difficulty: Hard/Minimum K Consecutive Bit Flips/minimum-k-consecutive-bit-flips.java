class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] flip = new int[n];
        int curFlips = 0;
        int ans = 0;
        
        for (int i = 0; i < n; ++i) {
            curFlips += flip[i];
            if (i >= k) {
                curFlips -= flip[i - k];
            }
            
            if ((arr[i] ^ (curFlips & 1)) == 0) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                flip[i] = 1;
                ++curFlips;
            }
        }
        
        return ans;
    }
}
