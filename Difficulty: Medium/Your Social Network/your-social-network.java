import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        int n = arr.length + 1; // users are 1..n

        // Build parent array: parent[i] = friend of i (0 if none)
        int[] parent = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            parent[i] = arr[i - 2];
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // For each user i from 2 to n
        for (int i = 2; i <= n; i++) {
            int curr = i;
            int dist = 0;

            // Follow links until no more friends
            while (parent[curr] != 0) {
                curr = parent[curr];
                dist++;
                int j = curr;
                int k = dist;

                // We need to output in order of j from 1 to i-1.
                // But since we traverse upwards, j will naturally be in decreasing order.
                // So we cannot directly add; instead, we'll collect and sort later per i.
                // Simpler: collect all (j,k) pairs for this i, then sort by j.

                // To keep it simple and within constraints, we'll collect in a list.
            }
        }

        // Better structure: for each i, collect all reachable (j,k), sort by j, then add to result.
        result.clear();

        for (int i = 2; i <= n; i++) {
            ArrayList<int[]> pairs = new ArrayList<>();
            int curr = i;
            int dist = 0;

            while (parent[curr] != 0) {
                curr = parent[curr];
                dist++;
                pairs.add(new int[]{curr, dist});
            }

            // Sort by j (curr) ascending
            pairs.sort((a, b) -> Integer.compare(a[0], b[0]));

            for (int[] p : pairs) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(i);
                triplet.add(p[0]);
                triplet.add(p[1]);
                result.add(triplet);
            }
        }

        return result;
    }
}