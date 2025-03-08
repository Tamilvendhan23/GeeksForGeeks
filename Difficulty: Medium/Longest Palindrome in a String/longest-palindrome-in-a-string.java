//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // Variables to track the longest palindrome
        int start = 0;
        int maxLength = 1;
        
        // Iterate through each character as potential center
        for (int i = 0; i < s.length(); i++) {
            // Check odd length palindromes (center at i)
            int len1 = expandAroundCenter(s, i, i);
            // Check even length palindromes (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get maximum length from both cases
            int currMax = Math.max(len1, len2);
            
            // Update start and maxLength if current palindrome is longer
            if (currMax > maxLength) {
                maxLength = currMax;
                start = i - (currMax - 1) / 2;
            }
        }
        
        // Return the substring using start index and length
        return s.substring(start, start + maxLength);
    }
    
    // Helper method to expand around center
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length of palindrome
        return right - left - 1;
    }
}