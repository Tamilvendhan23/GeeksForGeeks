class Solution {
    int maxRemove(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // union stones that share row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, parent, rank);
                }
            }
        }

        // count number of connected components
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findParent(i, parent));
        }

        // max stones removable = total stones - components
        return n - set.size();
    }

    private int findParent(int x, int[] parent) {
        if (parent[x] == x) return x;
        parent[x] = findParent(parent[x], parent); // path compression
        return parent[x];
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int px = findParent(x, parent);
        int py = findParent(y, parent);
        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
