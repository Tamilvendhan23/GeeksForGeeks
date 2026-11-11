class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If current value already exists within the last k positions
            if (window.contains(arr[i])) {
                return true;
            }

            window.add(arr[i]);

            // Keep only elements whose index is within distance k
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }

        return false;
    }
}