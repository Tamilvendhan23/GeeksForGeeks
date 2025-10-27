import java.util.*;

class Solution {
    static class Pair {
        int sum, i, j;
        Pair(int s, int i, int j) {
            this.sum = s;
            this.i = i;
            this.j = j;
        }
    }
    
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0)
            return result;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        Set<String> visited = new HashSet<>();

        pq.offer(new Pair(arr1[0] + arr2[0], 0, 0));
        visited.add("0#0");

        while (!pq.isEmpty() && result.size() < k) {
            Pair cur = pq.poll();
            int i = cur.i, j = cur.j;
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            result.add(pair);

            // Push next in arr1
            if (i + 1 < arr1.length && !visited.contains((i + 1) + "#" + j)) {
                pq.offer(new Pair(arr1[i + 1] + arr2[j], i + 1, j));
                visited.add((i + 1) + "#" + j);
            }

            // Push next in arr2
            if (j + 1 < arr2.length && !visited.contains(i + "#" + (j + 1))) {
                pq.offer(new Pair(arr1[i] + arr2[j + 1], i, j + 1));
                visited.add(i + "#" + (j + 1));
            }
        }

        return result;
    }
}
