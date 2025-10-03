import java.util.*;

class Solution {
    // mapping for digits 0–9
    private static final String[] keypad = {
        "",    // 0 → no letters
        "",    // 1 → no letters
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };

    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        // Start recursion with empty prefix, at index 0
        backtrack(arr, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int[] arr, int idx, StringBuilder prefix, ArrayList<String> result) {
        // base case: if we have assigned letters for all digits
        if (idx == arr.length) {
            result.add(prefix.toString());
            return;
        }

        int digit = arr[idx];
        // if digit is 0 or 1, skip (no letters), you can also handle by returning or ignoring
        if (digit < 2 || digit > 9) {
            // Option A: skip this digit and move ahead
            backtrack(arr, idx + 1, prefix, result);
            return;
        }

        String letters = keypad[digit];
        for (char ch : letters.toCharArray()) {
            prefix.append(ch);
            backtrack(arr, idx + 1, prefix, result);
            // backtrack: remove last appended character
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {2, 3};
        System.out.println(sol.possibleWords(arr1));  // expected [ad, ae, af, bd, be, bf, cd, ce, cf]

        int[] arr2 = {2};
        System.out.println(sol.possibleWords(arr2));  // expected [a, b, c]
    }
}
