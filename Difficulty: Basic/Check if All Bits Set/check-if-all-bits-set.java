class Solution {
    public boolean isBitSet(int n) {
        if (n == 0) return false;
        return (n & (n + 1)) == 0;
    }
}
