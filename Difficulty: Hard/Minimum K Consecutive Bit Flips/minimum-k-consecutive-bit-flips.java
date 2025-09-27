class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int res = 0, flip = 0;
        int[] hint = new int[n + 1]; // track where flips end

        for (int i = 0; i < n; i++) {
            flip += hint[i]; // remove expired flips
            if ((arr[i] + flip) % 2 == 0) { // bit is 0 after flips
                if (i + k > n) return -1;   // not enough space to flip
                res++;
                flip++;
                hint[i + k]--; // end effect of this flip
            }
        }
        return res;
    }
}
