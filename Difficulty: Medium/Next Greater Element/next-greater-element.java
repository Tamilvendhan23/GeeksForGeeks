//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1)); // Initialize with -1
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {  // Traverse from right to left
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();  // Remove smaller elements
            }
            if (!stack.isEmpty()) {
                result.set(i, stack.peek()); // NGE found
            }
            stack.push(arr[i]); // Push current element to stack
        }

        return result;
    }
}