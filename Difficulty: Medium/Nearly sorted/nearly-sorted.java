import java.util.PriorityQueue;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;
        int idx = 0;

        // Insert first (k+1) elements into the minHeap
        for (int i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        // For rest of the elements, add to heap and extract min for result
        for (int i = k + 1; i < n; i++) {
            arr[idx++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        // Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[idx++] = minHeap.poll();
        }
    }
}
