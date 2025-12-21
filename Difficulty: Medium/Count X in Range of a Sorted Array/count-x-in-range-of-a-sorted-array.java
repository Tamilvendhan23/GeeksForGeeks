import java.util.*;

class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        int n = arr.length;

        // value -> list of indices where it appears
        HashMap<Integer, ArrayList<Integer>> posMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            posMap.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            ArrayList<Integer> list = posMap.get(x);
            if (list == null) {
                ans.add(0);
                continue;
            }

            int leftIdx = lowerBound(list, l);      // first pos >= l
            int rightIdx = upperBound(list, r);     // first pos > r

            int count = rightIdx - leftIdx;
            if (count < 0) count = 0;
            ans.add(count);
        }

        return ans;
    }

    // first index i such that list.get(i) >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size(); // [lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // first index i such that list.get(i) > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
