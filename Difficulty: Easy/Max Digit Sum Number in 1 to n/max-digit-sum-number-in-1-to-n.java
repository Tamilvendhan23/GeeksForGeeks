class Solution {
    public int findMax(int n) {
        int ans = n;
        int maxSum = digitSum(n);

        // Try decreasing each digit by 1 and setting all right digits to 9
        int b = 1; // place value (1, 10, 100, ...)
        int x = n;

        while (x > 0) {
            // Get the last digit
            int lastDigit = x % 10;

            // If digit is 0, we can't decrease it, so skip
            if (lastDigit > 0) {
                // Create candidate: decrease current digit by 1, set all right digits to 9
                int candidate = (x - 1) * b + (b - 1);
                int sum = digitSum(candidate);

                // Update answer if we found better digit sum, or same sum but larger number
                if (sum > maxSum || (sum == maxSum && candidate > ans)) {
                    maxSum = sum;
                    ans = candidate;
                }
            }

            // Move to next digit
            x /= 10;
            b *= 10;
        }

        return ans;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}