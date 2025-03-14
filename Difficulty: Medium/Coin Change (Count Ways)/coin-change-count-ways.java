//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        // Create a DP array to store the number of combinations for each value up to 'sum'
        int dp[] = new int[sum + 1];
        
        // Base condition: There is one way to make 0 sum (by choosing no coins)
        dp[0] = 1;
        
        // Iterate through each coin in the coins array
        for (int coin : coins) {
            // For each coin, update the dp array for possible sums
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        // The final answer will be stored at dp[sum]
        return dp[sum];
    }
}