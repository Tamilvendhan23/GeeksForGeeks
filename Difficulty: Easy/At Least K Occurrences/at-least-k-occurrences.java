class Solution {
    public int firstElementKTime(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : arr) {
            int count = freq.getOrDefault(x, 0) + 1;
            freq.put(x, count);

            if (count == k) {
                return x;
            }
        }

        return -1;
    }
}