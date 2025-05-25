// import java.util.HashSet;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;

        // Step 1: Square all elements and store them
        int[] squares = new int[n];
        for (int i = 0; i < n; i++) {
            squares[i] = arr[i] * arr[i];
        }

        // Step 2: Check for every pair (a^2 + b^2) and see if it's in the set
        HashSet<Integer> squareSet = new HashSet<>();
        for (int val : squares) {
            squareSet.add(val);
        }

        // Step 3: Try all pairs (a, b) and check if a^2 + b^2 exists
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = squares[i] + squares[j];
                if (squareSet.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}