//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1; // Size of complete sequence (1 to n)
        long expectedSum = ((long) n * (n + 1)) / 2; // Use long to avoid overflow
        long actualSum = 0;
        
        // Calculate sum of array elements
        for (int num : arr) {
            actualSum += num;
        }
        
        // Missing number is the difference
        return (int) (expectedSum - actualSum);
    }
}