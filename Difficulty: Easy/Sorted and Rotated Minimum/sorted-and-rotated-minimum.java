//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function he 
        int low = 0, high = arr.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // If the rightmost element is greater than the mid, minimum is in the left half
            if (arr[mid] < arr[high]) {
                high = mid;
            }
            // If the mid element is greater than the rightmost, minimum is in the right half
            else if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            // When arr[mid] == arr[high], reduce the search space
            else {
                high--;
            }
        }
        
        return arr[low];
    }
}
