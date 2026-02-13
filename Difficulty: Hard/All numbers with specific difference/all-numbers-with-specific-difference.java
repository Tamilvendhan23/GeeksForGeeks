class Solution {
    private boolean isGreater(int val, int d) {
        int digitSum = 0;
        int tmp = val;
        while (tmp > 0) {
            digitSum += tmp % 10;
            tmp /= 10;
        }
        return val - digitSum >= d;
    }

    public int getCount(int n, int d) {
        if (n < 1) return 0;
        
        // Binary search for the smallest number mini where mini - digitSum(mini) >= d
        int mini = n + 1;
        int s = 1, e = n;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (isGreater(mid, d)) {
                mini = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        // Count is numbers from mini to n inclusive
        return n + 1 - mini;
    }
};
