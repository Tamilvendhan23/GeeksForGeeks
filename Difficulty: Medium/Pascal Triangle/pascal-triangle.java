//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long val = 1;
        row.add(1); // first element is always 1

        for (int k = 1; k < n; k++) {
            // Compute next value using previous value to avoid factorials
            val = val * (n - k);
            val = val / k;
            row.add((int) val); // cast to int as we are returning ArrayList<Integer>
        }

        return row;
    }
}
