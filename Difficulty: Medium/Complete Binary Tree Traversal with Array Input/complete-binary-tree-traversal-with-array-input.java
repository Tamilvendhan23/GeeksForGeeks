import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0, levelSize = 1;

        while (i < n) {
            int end = Math.min(i + levelSize, n);
            ArrayList<Integer> level = new ArrayList<>();

            for (int j = i; j < end; j++) {
                level.add(arr[j]);
            }

            Collections.sort(level);
            ans.add(level);

            i = end;
            levelSize *= 2;
        }

        return ans;
    }
}