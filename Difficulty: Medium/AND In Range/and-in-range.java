class Solution {
    public int andInRange(int l, int r) {
        while (r > l) {
            r = r & (r - 1);   // clear lowest set bit of r
        }
        return r;
    }
}
