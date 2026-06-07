class Solution {
    public String profession(int level, int pos) {
        // Count set bits in (pos - 1)
        int count = 0;
        int n = pos - 1;
        
        while (n > 0) {
            n &= (n - 1);  // Remove the rightmost set bit
            count++;
        }
        
        // If set bit count is even -> Engineer, odd -> Doctor
        return (count % 2 == 0) ? "Engineer" : "Doctor";
    }
}