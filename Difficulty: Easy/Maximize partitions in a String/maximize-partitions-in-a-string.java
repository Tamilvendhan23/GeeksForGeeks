//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int maxPartitions(String s) {
        int[] lastIndex = new int[26]; // Stores the last occurrence of each character
        
        // Step 1: Store last occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Traverse and count partitions
        int partitions = 0;
        int maxLastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLastIndex = Math.max(maxLastIndex, lastIndex[s.charAt(i) - 'a']);
            
            if (i == maxLastIndex) { // If reached max last index, we have a partition
                partitions++;
            }
        }
        
        return partitions;
    }

}
