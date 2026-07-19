import java.util.*;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int q = queries.length;

        // inc[i] = last index of non-decreasing run starting at i
        int[] inc = new int[n];
        inc[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                inc[i] = inc[i + 1];
            } else {
                inc[i] = i;
            }
        }

        // dec[i] = first index of non-increasing run ending at i
        int[] dec = new int[n];
        dec[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                dec[i] = dec[i - 1];
            } else {
                dec[i] = i;
            }
        }

        ArrayList<Boolean> res = new ArrayList<>(q);
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // if non-decreasing segment from l and non-increasing segment to r overlap,
            // subarray [l..r] is a mountain
            if (inc[l] >= dec[r]) {
                res.add(Boolean.TRUE);
            } else {
                res.add(Boolean.FALSE);
            }
        }

        return res;
    }
}