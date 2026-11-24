import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        if (n < 4) {
            res.add(-1); res.add(-1); res.add(-1); res.add(-1);
            return res;
        }

        // value -> sorted list of indices having that value
        HashMap<Integer, ArrayList<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // For current suffix (indices > a):
        // pairCnt[sum] = number of pairs (c, d) with a < c < d
        HashMap<Integer, Integer> pairCnt = new HashMap<>();
        for (int c = 1; c < n; c++) {
            for (int d = c + 1; d < n; d++) {
                pairCnt.merge(arr[c] + arr[d], 1, Integer::sum);
            }
        }

        for (int a = 0; a <= n - 4; a++) {
            int va = arr[a];
            ArrayList<Integer> vaList = pos.get(va);

            for (int b = a + 1; b < n; b++) {
                int sum = va + arr[b];

                Integer totalObj = pairCnt.get(sum);
                if (totalObj == null || totalObj == 0) continue;
                int total = totalObj;

                // Pairs with this sum that contain index b:
                // either (b, d) with arr[d] == arr[a],
                // or (c, b) with a < c < b and arr[c] == arr[a].
                int containing = countAfter(vaList, b)
                               + countBetween(vaList, a, b);

                if (total > containing) {
                    // Find lexicographically smallest (c, d)
                    for (int c = a + 1; c < n; c++) {
                        if (c == b) continue;

                        int need = sum - arr[c];
                        ArrayList<Integer> dList = pos.get(need);
                        if (dList == null) continue;

                        int d = firstAfterExcluding(dList, c, b);
                        if (d != -1) {
                            res.add(a);
                            res.add(b);
                            res.add(c);
                            res.add(d);
                            return res;
                        }
                    }
                }
            }

            // Move suffix start from a + 1 to a + 2:
            // remove every pair that uses index a + 1 as its smaller index.
            if (a + 1 < n) {
                int v = arr[a + 1];
                for (int d = a + 2; d < n; d++) {
                    pairCnt.merge(v + arr[d], -1, Integer::sum);
                }
            }
        }

        res.add(-1); res.add(-1); res.add(-1); res.add(-1);
        return res;
    }

    private int countAfter(ArrayList<Integer> list, int x) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) <= x) lo = mid + 1;
            else hi = mid;
        }
        return list.size() - lo;
    }

    private int countBetween(ArrayList<Integer> list, int low, int high) {
        int lo = 0, hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) <= low) lo = mid + 1;
            else hi = mid;
        }
        int start = lo;

        lo = start;
        hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) < high) lo = mid + 1;
            else hi = mid;
        }

        return lo - start;
    }

    private int firstAfterExcluding(ArrayList<Integer> list, int after, int exclude) {
        int lo = 0, hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) <= after) lo = mid + 1;
            else hi = mid;
        }

        if (lo < list.size() && list.get(lo) == exclude) lo++;

        return lo < list.size() ? list.get(lo) : -1;
    }
}