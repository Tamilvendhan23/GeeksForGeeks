//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // ArrayList to store tails of increasing subsequences
        ArrayList<Integer> tails = new ArrayList<>();
        
        for (int num : arr) {
            // Binary search to find position to insert/replace
            int left = 0;
            int right = tails.size();
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            // If at end, add new element
            if (left == tails.size()) {
                tails.add(num);
            }
            // Otherwise replace the element at found position
            else {
                tails.set(left, num);
            }
        }
        
        return tails.size();
    }

}