class Solution {
    public boolean isSumOfConsecutive(int n) {
        // A number can be expressed as sum of consecutive positive integers
        // if and only if it is NOT a power of 2
        // Use bitwise operation: n & (n-1) == 0 means n is a power of 2
        return (n & (n - 1)) != 0 && n > 0;
    }
}