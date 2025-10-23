class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] pt = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(pt[0], pt[1])));
        }
        return ans; // driver sorts it
    }
}
