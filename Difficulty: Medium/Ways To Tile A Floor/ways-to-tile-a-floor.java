class Solution {
    public int numberOfWays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = b + a;
            a = temp;
        }
        return b;
    }
}

