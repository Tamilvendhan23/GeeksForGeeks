//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// import java.util.PriorityQueue;

class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        
        // Step 1: Create prefix sum array
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        // Step 2: Min-heap to store k largest sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Step 3: Generate all subarray sums and maintain top k in minHeap
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                int currSum = prefixSum[end] - prefixSum[start];
                
                if (minHeap.size() < k) {
                    minHeap.add(currSum);
                } else if (currSum > minHeap.peek()) {
                    minHeap.poll();  // Remove smallest among top k
                    minHeap.add(currSum);
                }
            }
        }
        
        // Step 4: The top of the minHeap is the K-th largest
        return minHeap.peek();
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.kthLargest(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends