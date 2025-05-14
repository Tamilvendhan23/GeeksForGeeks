//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char currentChar = result.charAt(j);
                if (currentChar == prevChar) {
                    count++;
                } else {
                    temp.append(count).append(prevChar);
                    count = 1;
                    prevChar = currentChar;
                }
            }

            // Append the last counted group
            temp.append(count).append(prevChar);
            result = temp.toString();
        }

        return result;
    }
}

