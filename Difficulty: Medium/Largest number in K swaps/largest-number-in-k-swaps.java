//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    String max;

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] chars = s.toCharArray();
        solve(chars, k);
        return max;
    }

    private void solve(char[] chars, int k) {
        if (k == 0) return;

        int n = chars.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[j] > chars[i]) {
                    swap(chars, i, j);

                    String current = new String(chars);
                    if (current.compareTo(max) > 0) {
                        max = current;
                    }

                    solve(chars, k - 1);  // reduce swap count
                    swap(chars, i, j);    // backtrack
                }
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

