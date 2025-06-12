// import java.util.*; 

class Pair {
    int diff;
    int value;

    Pair(int diff, int value) {
        this.diff = diff;
        this.value = value;
    }
}

class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff)
                return b.diff - a.diff; // higher diff first
            else
                return a.value - b.value; // smaller value removed first
        });

        for (int val : arr) {
            if (val == x) continue; // Exclude x

            int diff = Math.abs(val - x);
            maxHeap.add(new Pair(diff, val));

            if (maxHeap.size() > k) {
                maxHeap.poll(); // Keep only k closest
            }
        }

        // Extract elements in order of closeness
        List<Pair> list = new ArrayList<>(maxHeap);
        list.sort((a, b) -> {
            if (a.diff != b.diff)
                return a.diff - b.diff;
            else
                return b.value - a.value; // Prefer larger value on tie
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).value;
        }

        return result;
    }
}
