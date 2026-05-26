class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;
        int ones = 0;
        for (int x : arr) {
            if (x == 1) ones++;
        }

        int leftOne = 0;
        int rightZero = 0;
        for (int x : arr) {
            if (x == 0) rightZero++;
        }

        int ans = rightZero; // split before index 0

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) leftOne++;
            else rightZero--;

            ans = Math.min(ans, leftOne + rightZero);
        }

        return ans;
    }
}