//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int[] transformed = new int[n];

        int left = 0, right = n - 1;
        int index = A >= 0 ? n - 1 : 0;

        while (left <= right) {
            int leftVal = applyFunction(arr[left], A, B, C);
            int rightVal = applyFunction(arr[right], A, B, C);

            if (A >= 0) { // Fill from end
                if (leftVal > rightVal) {
                    transformed[index--] = leftVal;
                    left++;
                } else {
                    transformed[index--] = rightVal;
                    right--;
                }
            } else { // Fill from beginning
                if (leftVal < rightVal) {
                    transformed[index++] = leftVal;
                    left++;
                } else {
                    transformed[index++] = rightVal;
                    right--;
                }
            }
        }

        for (int val : transformed)
            result.add(val);
        return result;
    }

    private int applyFunction(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
}
