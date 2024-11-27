//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {

    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;

        // Calculate total sum of the array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Initialize minDiff as the maximum possible integer value
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1); // -1 indicates uncomputed values

        return minDifferenceHelper(arr, n, sum, 0, 0, dp);
    }

    public int minDifferenceHelper(int[] arr, int n, int totalSum, int currentSum, int idx, int[] dp) {
        if (idx == n) {
            // Calculate the difference between the two subsets
            int diff = Math.abs(totalSum - 2 * currentSum);
            return diff;
        }

        // Memoization check
        if (dp[currentSum] != -1) {
            return dp[currentSum];
        }

        // Take the current element
        int take = minDifferenceHelper(arr, n, totalSum, currentSum + arr[idx], idx + 1, dp);

        // Don't take the current element
        int dontTake = minDifferenceHelper(arr, n, totalSum, currentSum, idx + 1, dp);

        // Store the result and return the minimum of the two possibilities
        dp[currentSum] = Math.min(take, dontTake);

        return dp[currentSum];
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends