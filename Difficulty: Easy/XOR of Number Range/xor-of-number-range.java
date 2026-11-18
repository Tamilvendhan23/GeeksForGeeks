class Solution {
    public int findXOR(int l, int r) {
        return xorUpto(l - 1) ^ xorUpto(r);
    }

    private int xorUpto(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0; // n % 4 == 3
        }
    }
}