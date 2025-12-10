import java.util.ArrayList;

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int xorVal = 0;

        // XOR all array elements
        for (int i = 0; i < n; i++) {
            xorVal ^= arr[i];
        }

        // XOR with all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorVal ^= i;
        }

        // xorVal = missing ^ repeating
        // Get rightmost set bit
        int setBit = xorVal & -xorVal;

        int x = 0; // candidate 1
        int y = 0; // candidate 2

        // Divide array elements into two sets based on setBit
        for (int i = 0; i < n; i++) {
            if ((arr[i] & setBit) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }

        // Divide numbers 1..n into two sets based on setBit
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // Now x and y are {missing, repeating} in some order
        int repeating = 0, missing = 0;
        for (int val : arr) {
            if (val == x) {
                repeating = x;
                missing = y;
                break;
            } else if (val == y) {
                repeating = y;
                missing = x;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating); // duplicate
        ans.add(missing);   // missing
        return ans;
    }
}

