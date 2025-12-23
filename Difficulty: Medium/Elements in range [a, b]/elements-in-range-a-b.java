import java.util.*;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);  // O(n log n)
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];

            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);

            result.add(right - left);
        }
        return result;
    }

    // first index where arr[i] >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // first index where arr[i] > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
