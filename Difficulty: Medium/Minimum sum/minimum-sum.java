import java.util.*;

class Solution {
    String minSum(int[] arr) {
        // Sort the array to get digits in ascending order
        Arrays.sort(arr);
        
        // Create two numbers by distributing digits alternately
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }
        
        // Add the two numbers digit by digit
        return addStrings(num1.toString(), num2.toString());
    }
    
    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            
            i--;
            j--;
        }
        
        // Reverse to get the correct order and remove leading zeros
        result.reverse();
        
        // Remove leading zeros
        int start = 0;
        while (start < result.length() - 1 && result.charAt(start) == '0') {
            start++;
        }
        
        return result.substring(start);
    }
}

// // Test the solution
// public class MinimumSumTest {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
        
//         // Test case 1
//         int[] arr1 = {6, 8, 4, 5, 2, 3};
//         System.out.println("Input: " + Arrays.toString(arr1));
//         System.out.println("Output: " + sol.minSum(arr1)); // Expected: "604"
        
//         // Test case 2
//         int[] arr2 = {5, 3, 0, 7, 4};
//         System.out.println("\nInput: " + Arrays.toString(arr2));
//         System.out.println("Output: " + sol.minSum(arr2)); // Expected: "82"
        
//         // Test case 3
//         int[] arr3 = {9, 4};
//         System.out.println("\nInput: " + Arrays.toString(arr3));
//         System.out.println("Output: " + sol.minSum(arr3)); // Expected: "13"
        
//         // Additional test case with zeros
//         int[] arr4 = {0, 0, 1, 2};
//         System.out.println("\nInput: " + Arrays.toString(arr4));
//         System.out.println("Output: " + sol.minSum(arr4)); // Expected: "12"
//     }
// }