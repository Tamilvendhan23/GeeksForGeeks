class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int num : arr) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
            
            if (minHeap.size() == k) {
                result.add(minHeap.peek());
            } else {
                result.add(-1);
            }
        }
        return result;
    }
}