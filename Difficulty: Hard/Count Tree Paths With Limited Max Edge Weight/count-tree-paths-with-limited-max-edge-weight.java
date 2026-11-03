class Solution {
    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        int m = edges.length;
        Integer[] edgeIdx = new Integer[m];
        for (int i = 0; i < m; i++) edgeIdx[i] = i;

        java.util.Arrays.sort(edgeIdx, (a, b) ->
            Integer.compare(edges[a][2], edges[b][2]));

        Integer[] queryIdx = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) queryIdx[i] = i;

        java.util.Arrays.sort(queryIdx, (a, b) ->
            Integer.compare(queries[a], queries[b]));

        int[] parent = new int[n + 1];
        long[] size = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long validPaths = 0;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(queries.length, 0));
        int ei = 0;

        for (int qi : queryIdx) {
            int x = queries[qi];

            while (ei < m && edges[edgeIdx[ei]][2] <= x) {
                int[] e = edges[edgeIdx[ei]];
                int ru = find(parent, e[0]);
                int rv = find(parent, e[1]);

                if (ru != rv) {
                    // Remove paths entirely within the two old components,
                    // then add paths in the merged component.
                    validPaths -= size[ru] * (size[ru] - 1) / 2;
                    validPaths -= size[rv] * (size[rv] - 1) / 2;

                    if (size[ru] < size[rv]) {
                        int tmp = ru;
                        ru = rv;
                        rv = tmp;
                    }

                    parent[rv] = ru;
                    size[ru] += size[rv];

                    validPaths += size[ru] * (size[ru] - 1) / 2;
                }
                ei++;
            }

            ans.set(qi, (int) validPaths);
        }

        return ans;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}