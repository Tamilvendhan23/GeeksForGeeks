//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    // Merge Sort function that returns the inversion count.
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left half
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions while merging
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merge function that counts inversions while merging two halves
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left; // Starting index for the merged array
        int invCount = 0;

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Count inversions: All remaining elements in the left subarray form inversions
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of the left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of the right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
