import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : b) set.add(x);

        ArrayList<Integer> seq = new ArrayList<>();
        for (int x : a) {
            if (set.contains(x)) seq.add(x);
        }

        return a.length + b.length - 2 * lisLength(seq);
    }

    private int lisLength(ArrayList<Integer> arr) {
        ArrayList<Integer> tail = new ArrayList<>();
        for (int x : arr) {
            int idx = Collections.binarySearch(tail, x);
            if (idx < 0) idx = -(idx + 1);

            if (idx == tail.size()) tail.add(x);
            else tail.set(idx, x);
        }
        return tail.size();
    }
}