import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        if (n <= 1) {
            return 0;
        }

        // BFS from any node to find one endpoint of the diameter
        int[] first = bfs(adj, 0);
        int farthestNode = first[0];

        // BFS from the endpoint to find the diameter length
        int[] second = bfs(adj, farthestNode);
        int diameter = second[1];

        // Radius = ceil(diameter / 2)
        return (diameter + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current)) {
                // Houses are numbered 1 to n, but array indices are 0 to n-1
                int next = neighbor - 1;

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);

                    if (distance[next] > maxDistance) {
                        maxDistance = distance[next];
                        farthestNode = next;
                    }
                }
            }
        }

        return new int[] {farthestNode, maxDistance};
    }
}