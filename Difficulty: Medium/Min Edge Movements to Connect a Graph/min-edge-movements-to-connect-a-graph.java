class Solution {
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }
    
    int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            int ru = find(u, parent);
            int rv = find(v, parent);
            if (ru == rv) continue; // already in same component

            // union by size
            if (size[ru] < size[rv]) {
                int tmp = ru; ru = rv; rv = tmp;
            }
            parent[rv] = ru;
            size[ru] += size[rv];
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i) {
                components++;
            }
        }

        return components - 1;
    }
}