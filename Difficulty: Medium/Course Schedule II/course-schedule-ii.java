class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer> order = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] pre: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for(int next: adj.get(curr)) {
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.add(next);
            }
        }
        if(order.size() == n)
            return order;
        // if cycle detected, impossible to finish all courses
        return new ArrayList<>();
    }
}
