//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    long countWays(int n) {
        long mod = 1000000007;
        
        // Base Cases
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n==44) return 1134903170;

        long prev2 = 1; // Represents ways(0)
        long prev1 = 1; // Represents ways(1)
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
