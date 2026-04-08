class Solution {
    void segregate0and1(int[] arr) {
        int count0 = 0;
        // Count 0s
        for (int x : arr) {
            if (x == 0) count0++;
        }
        // Fill 0s in left
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        // Fill 1s in right
        for (int i = count0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }
}