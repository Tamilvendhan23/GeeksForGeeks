import java.util.*;

class Solution {
    public int minValue(String s, int k) {
        // Step 1: Frequency count
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max Heap for frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        // Step 3: Remove k characters
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            if (top > 1) maxHeap.add(top - 1);
        }

        // Step 4: Calculate final value
        int result = 0;
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            result += val * val;
        }

        return result;
    }
}