//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W
    public static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        // Create a 2D DP table
        // dp[i][w] represents maximum value possible with first i items and capacity w
        int[][] dp = new int[n + 1][W + 1];
        
        // Build table dp[][] in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // Don't include current item
                dp[i][w] = dp[i-1][w];
                
                // Include current item if its weight fits
                if (wt[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], 
                                      val[i-1] + dp[i-1][w - wt[i-1]]);
                }
            }
        }
        
        return dp[n][W];
    }
}