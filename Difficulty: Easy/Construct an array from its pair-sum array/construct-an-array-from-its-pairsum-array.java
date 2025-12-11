import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        // If there is only one pair-sum, original array has exactly 2 numbers
        if (arr.length == 1) {
            ans.add(1);
            ans.add(arr[0] - 1);
            return ans;
        }

        // Find size n of original array from m = arr.length = n * (n - 1) / 2
        int m = arr.length;
        int n = (int) ((1 + Math.sqrt(1 + 8L * m)) / 2);

        int[] res = new int[n];

        // Compute res[0] using first two sums and the first non-res[0] pair sum
        int a = arr[0];          // res[0] + res[1]
        int b = arr[1];          // res[0] + res[2]
        int c = arr[n - 1];      // res[1] + res[2]
        res[0] = (a + b - c) / 2;

        // Compute remaining elements
        for (int i = 1; i < n; i++) {
            res[i] = arr[i - 1] - res[0];
        }

        for (int x : res) {
            ans.add(x);
        }
        return ans;
    }
}
