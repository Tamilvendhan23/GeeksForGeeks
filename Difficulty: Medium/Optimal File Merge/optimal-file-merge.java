import java.util.PriorityQueue;

class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int size : files) {
            pq.add(size);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int merged = first + second;
            totalCost += merged;

            pq.add(merged);
        }

        return totalCost;
    }
}