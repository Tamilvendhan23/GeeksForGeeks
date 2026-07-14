class Solution {
    public int find(int[] arr) {
        long req = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            req = (arr[i] + req + 1) / 2; // ceil((arr[i] + req) / 2)
        }

        return (int) Math.max(1, req);
    }
}