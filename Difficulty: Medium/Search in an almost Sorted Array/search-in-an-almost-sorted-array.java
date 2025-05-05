//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check mid
            if (arr[mid] == target) return mid;

            // Check mid - 1
            if (mid > low && arr[mid - 1] == target) return mid - 1;

            // Check mid + 1
            if (mid < high && arr[mid + 1] == target) return mid + 1;

            // Decide which side to move
            if (arr[mid] > target) {
                high = mid - 2; // Eliminate mid and mid-1
            } else {
                low = mid + 2; // Eliminate mid and mid+1
            }
        }

        return -1; // Not found
    }
}



//{ Driver Code Starts.

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            int target = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            int ans = sln.findTarget(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends