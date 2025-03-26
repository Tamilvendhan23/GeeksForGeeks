//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// import java.util.HashSet
class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: Empty string can be segmented

        // Find the longest word in the dictionary to limit unnecessary checks
        int maxWordLength = 0;
        for (String word : dictionary) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        // Iterate over the string length
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxWordLength); j < i; j++) { // Limit to `maxWordLength`
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further, move to next `i`
                }
            }
        }
        return dp[n]; // Check if the entire string can be segmented
    }
}