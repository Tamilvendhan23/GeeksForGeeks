class Solution {
    public int minOperation(int n) {
        int operations = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
            }
            operations++;
        }

        return operations;
    }
}