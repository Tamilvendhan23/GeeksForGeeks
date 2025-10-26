import java.util.PriorityQueue;

class Solution {
    public static int minCost(int[] arr) {
        // PriorityQueue to act as Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.offer(rope);
        }
        int totalCost = 0;
        // While more than one rope remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll(); // Smallest rope
            int second = minHeap.poll(); // Next smallest rope
            int cost = first + second;
            totalCost += cost;
            minHeap.offer(cost); // Insert combined rope back
        }
        return totalCost;
    }
}
