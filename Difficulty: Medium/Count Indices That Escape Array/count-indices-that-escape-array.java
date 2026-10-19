class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = good, 3 = bad
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(arr, i, state)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int[] arr, int i, int[] state) {
        int n = arr.length;

        if (i < 0 || i >= n) return true;      // escaped array
        if (state[i] == 2) return true;        // already known good
        if (state[i] == 3) return false;       // already known bad
        if (state[i] == 1) return false;       // cycle detected

        state[i] = 1;                          // mark as visiting

        boolean result = dfs(arr, i + arr[i], state);

        state[i] = result ? 2 : 3;             // memoize result
        return result;
    }
}