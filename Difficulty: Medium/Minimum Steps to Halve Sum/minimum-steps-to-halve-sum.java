import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
            maxHeap.add((double) num);
        }
        
        double target = totalSum / 2;
        double currentSum = totalSum;
        int operations = 0;
        
        while (currentSum > target) {
            double largest = maxHeap.poll();
            double half = largest / 2;
            currentSum -= (largest - half);
            maxHeap.add(half);
            operations++;
        }
        
        return operations;
    }
}
