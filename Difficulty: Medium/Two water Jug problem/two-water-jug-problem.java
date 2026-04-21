class Solution {

    public int minSteps(int m, int n, int d) {
        
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;
        
        // IMPORTANT FIX
        if (d == m || d == n) return 1;
        
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
    
    private int pour(int fromCap, int toCap, int d) {
        int from = 0, to = 0;
        int step = 0;
        
        while (from != d && to != d) {
            
            if (from == 0) {
                from = fromCap;
                step++;
            }
            
            int transfer = Math.min(from, toCap - to);
            to += transfer;
            from -= transfer;
            step++;
            
            if (from == d || to == d) break;
            
            if (to == toCap) {
                to = 0;
                step++;
            }
        }
        
        return step;
    }
    
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}