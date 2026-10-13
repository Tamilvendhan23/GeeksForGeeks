import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] diff = new int[n + 2]; // 1-based indexing

        for (int j : updates) {
            diff[j]++;
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += diff[i];
            ans.add(sum);
        }

        return ans;
    }
}