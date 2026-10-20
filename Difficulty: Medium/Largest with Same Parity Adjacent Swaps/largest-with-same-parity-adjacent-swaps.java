import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;

        while (i < n) {
            int j = i;

            // Find maximal contiguous segment with same parity
            while (j + 1 < n && (arr[j] & 1) == (arr[j + 1] & 1)) {
                j++;
            }

            // Copy and sort this segment in descending order
            Integer[] segment = new Integer[j - i + 1];
            for (int k = i; k <= j; k++) {
                segment[k - i] = arr[k];
            }

            Arrays.sort(segment, Collections.reverseOrder());

            for (int value : segment) {
                ans.add(value);
            }

            i = j + 1;
        }

        return ans;
    }
}