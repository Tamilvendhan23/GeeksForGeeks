import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.sum - x.sum);
        Set<String> visited = new HashSet<>();

        int i = n - 1;
        int j = n - 1;

        // Add initial (max1 + max2)
        maxHeap.add(new Pair(a[i] + b[j], i, j));
        visited.add(i + "_" + j);

        while (result.size() < k && !maxHeap.isEmpty()) {
            Pair top = maxHeap.poll();
            result.add(top.sum);

            int x = top.i;
            int y = top.j;

            // Next pair (x-1, y)
            if (x - 1 >= 0) {
                String key = (x - 1) + "_" + y;
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(a[x - 1] + b[y], x - 1, y));
                    visited.add(key);
                }
            }

            // Next pair (x, y-1)
            if (y - 1 >= 0) {
                String key = x + "_" + (y - 1);
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(a[x] + b[y - 1], x, y - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }

    class Pair {
        int sum, i, j;
        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
}