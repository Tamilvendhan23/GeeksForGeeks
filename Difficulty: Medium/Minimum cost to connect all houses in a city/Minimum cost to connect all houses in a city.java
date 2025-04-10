class Solution {
    public int minCost(int[][] a) {
        int n = a.length, ans = 0;
        boolean[] vis = new boolean[n];
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.MAX_VALUE, u = -1;
            for (int j = 0; j < n; j++)
                if (!vis[j] && d[j] < m) {
                    m = d[j];
                    u = j;
                }
            vis[u] = true;
            ans += m;
            for (int j = 0; j < n; j++)
                if (!vis[j])
                    d[j] = Math.min(d[j], Math.abs(a[u][0] - a[j][0]) + Math.abs(a[u][1] - a[j][1]));
        }
        return ans;
    }
}
