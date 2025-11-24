class Solution {

    // DSU (Disjoint Set Union) for Kruskal
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int secondMST(int V, int[][] edges) {
        int E = edges.length;

        // 1. Sort edges by weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // 2. Build the first MST using Kruskal
        DSU dsu = new DSU(V);
        int mstWeight = 0;
        int edgesUsed = 0;

        // store indices of edges that are in MST
        List<Integer> mstEdgeIdx = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (dsu.union(u, v)) {
                mstWeight += w;
                edgesUsed++;
                mstEdgeIdx.add(i);
                if (edgesUsed == V - 1) break;
            }
        }

        // Graph might already be disconnected, but by problem statement
        // it should allow at least one spanning tree. Still, safe check:
        if (edgesUsed != V - 1) {
            return -1;
        }

        int secondBest = Integer.MAX_VALUE;

        // 3. Try skipping each MST edge once and run Kruskal again
        for (int skipIndex : mstEdgeIdx) {
            DSU dsu2 = new DSU(V);
            int weight = 0;
            int used = 0;

            for (int i = 0; i < E; i++) {
                if (i == skipIndex) continue;  // skip this MST edge

                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];

                if (dsu2.union(u, v)) {
                    weight += w;
                    used++;
                    if (used == V - 1) break;
                }
            }

            // valid spanning tree and strictly greater than MST
            if (used == V - 1 && weight > mstWeight && weight < secondBest) {
                secondBest = weight;
            }
        }

        return (secondBest == Integer.MAX_VALUE) ? -1 : secondBest;
    }
}
