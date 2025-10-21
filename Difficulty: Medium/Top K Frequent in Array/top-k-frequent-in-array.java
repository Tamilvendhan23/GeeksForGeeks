import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) return result;

        // Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap to keep top k entries.
        // Order by frequency ascending; if frequencies are equal, order by value ascending
        // so that the smaller value is considered "smaller" and gets evicted first,
        // leaving the larger value among equals in the heap.
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return a.getValue() - b.getValue();
                } else {
                    return a.getKey() - b.getKey();
                }
            });

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }

        // Extract from heap into list: poll from smallest -> largest, addFirst to reverse,
        // so final order is most frequent first; for ties larger values come first.
        LinkedList<Integer> tmp = new LinkedList<>();
        while (!pq.isEmpty()) {
            tmp.addFirst(pq.poll().getKey());
        }

        result.addAll(tmp);
        return result;
    }
}