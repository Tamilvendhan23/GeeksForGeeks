//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        if (n < 2) {
            return 0; // Need at least 2 days for a transaction
        }
        
        // DP table: dp[t][i] represents max profit with t transactions up to day i
        int[][] dp = new int[k + 1][n];
        
        // For each transaction count from 1 to k
        for (int t = 1; t <= k; t++) {
            // max_prev represents the maximum of (dp[t-1][j-1] - prices[j]) for previous j
            int max_prev = -prices[0];
            
            // For each day starting from 1
            for (int i = 1; i < n; i++) {
                // Option 1: Do nothing, carry forward previous day's profit
                dp[t][i] = dp[t][i - 1];
                
                // Option 2: Sell on day i, maximize profit using max_prev
                dp[t][i] = Math.max(dp[t][i], prices[i] + max_prev);
                
                // Update max_prev for the next iteration
                max_prev = Math.max(max_prev, dp[t - 1][i - 1] - prices[i]);
            }
        }
        
        // Return max profit with at most k transactions
        return dp[k][n - 1];
    }
}