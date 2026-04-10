import java.util.*;

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) return new ArrayList<>();

        // smaller[i] = index of element smaller than arr[i] on its left; -1 if none
        int[] smaller = new int[n];
        int min = 0;
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        // greater[i] = index of element greater than arr[i] on its right; -1 if none
        int[] greater = new int[n];
        int max = n - 1;
        greater[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        // Find an index j such that it has both smaller on left and greater on right
        for (int j = 0; j < n; j++) {
            if (smaller[j] != -1 && greater[j] != -1) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(arr[smaller[j]]);
                ans.add(arr[j]);
                ans.add(arr[greater[j]]);
                return ans;
            }
        }

        return new ArrayList<>(); // no valid triplet
    }
}