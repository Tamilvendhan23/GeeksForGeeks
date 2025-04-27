//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Handle negative numbers
        boolean isNegative = false;
        if (s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }
        
        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        
        // If either string is "0", the result is "0"
        if (s1.equals("0") || s2.equals("0")) return "0";
        
        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m];
        
        // Multiply each digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                
                result[i + j + 1] = sum % 10; // Current place
                result[i + j] += sum / 10;    // Carry to next place
            }
        }
        
        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() != 0 || num != 0) {
                sb.append(num);
            }
        }
        
        // Add negative sign if needed
        if (isNegative) {
            sb.insert(0, '-');
        }
        
        return sb.toString();
    }
    
    private String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return i == str.length() ? "0" : str.substring(i);
    }
}
