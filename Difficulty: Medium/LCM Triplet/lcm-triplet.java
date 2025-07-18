class Solution {
    int lcmTriplets(int n) {
        // code here
         int ans;

        if (n < 3) {
            ans = n;
        }
        
        // If n is odd, the product of the top 3 numbers gives maximum LCM
        else if (n % 2 != 0) {
            ans = n * (n - 1) * (n - 2);
        }
        
        // If n is even and not divisible by 3, use n, n-1, n-3
        else if (n % 3 != 0) {
            ans = n * (n - 1) * (n - 3);
        }
        
        // If n is even and divisible by 3, use n-1, n-2, n-3
        else {
            ans = (n - 1) * (n - 2) * (n - 3);
        }

        return ans;
    }

        
    }
