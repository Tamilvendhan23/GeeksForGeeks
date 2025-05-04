//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    public int findSubString(String str) {
        int n = str.length();
        Set<Character> uniqueChars = new HashSet<>();
        
        // Step 1: Get all unique characters
        for (int i = 0; i < n; i++) {
            uniqueChars.add(str.charAt(i));
        }
        int uniqueCount = uniqueChars.size();
        
        Map<Character, Integer> freqMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int start = 0, count = 0;

        for (int end = 0; end < n; end++) {
            char endChar = str.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);

            if (freqMap.get(endChar) == 1) {
                count++; // unique character matched
            }

            // If current window contains all unique characters
            while (count == uniqueCount) {
                minLen = Math.min(minLen, end - start + 1);

                // Try to shrink the window
                char startChar = str.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                if (freqMap.get(startChar) == 0) {
                    count--; // a unique char is now missing
                }
                start++;
            }
        }
        return minLen;
    }
}
