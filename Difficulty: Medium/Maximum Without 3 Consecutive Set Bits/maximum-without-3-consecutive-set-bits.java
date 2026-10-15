class Solution {
    public int maxValue(int n) {
        int count = 0;

        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                count++;
                if (count == 3) {
                    n &= ~(1 << i); // clear current bit
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return n;
    }
}