class Solution {
    int subsetXORSum(int arr[]) {
        int n = arr.length;

        int OR = 0;
        for (int x : arr) {
            OR |= x;
        }

        return OR << (n - 1);
    }
}
