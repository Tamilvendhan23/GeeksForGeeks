//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        int result = 0;

        // iterate over each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = (1 << i);

            for (int num : arr) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }

            // if sum % 3 != 0, it means this bit is set in the unique number
            if (sum % 3 != 0) {
                result |= mask;
            }
        }

        return result;
    }
}
