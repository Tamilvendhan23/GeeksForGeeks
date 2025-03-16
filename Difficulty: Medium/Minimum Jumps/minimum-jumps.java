//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
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

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minJumps(int[] arr) {
        if (arr.length <= 1) return 0;  // Already at the end
        if (arr[0] == 0) return -1;     // Cannot move forward

        int maxReach = arr[0]; // Max index that can be reached
        int steps = arr[0];    // Steps we can still take in current reach
        int jumps = 1;         // Number of jumps required

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps;  // Reached the end

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;  // Using one step

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;  // Unable to proceed further
                steps = maxReach - i;  // Refill steps based on maximum reach
            }
        }
        return -1;  // No possible path to the end
    }
}
