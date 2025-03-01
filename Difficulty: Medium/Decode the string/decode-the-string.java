//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    public String decodeString(String s) {
        // Two stacks: one for numbers and one for strings
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number digit by digit
                currentNum = currentNum * 10 + (c - '0');
            } 
            else if (c == '[') {
                // Push current number and string to stacks
                numStack.push(currentNum);
                strStack.push(currentStr);
                // Reset for inner pattern
                currentNum = 0;
                currentStr = new StringBuilder();
            } 
            else if (c == ']') {
                // Pop number and previous string
                int num = numStack.pop();
                StringBuilder prevStr = strStack.pop();
                // Multiply current string by number and append to previous string
                for (int i = 0; i < num; i++) {
                    prevStr.append(currentStr);
                }
                currentStr = prevStr;
            } 
            else {
                // Add character to current string
                currentStr.append(c);
            }
        }
        
        return currentStr.toString();
    }
}
