import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int countValid(int n, int[] arr) {
        // Step 1: Mark forbidden digits
        Set<Integer> forbidden = new HashSet<>();
        for (int d : arr) forbidden.add(d);

        // Step 2: List of allowed digits
        List<Integer> allowed = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (!forbidden.contains(i)) {
                allowed.add(i);
            }
        }

        // Step 3: Edge case - if no allowed digits, all numbers are valid
        if (allowed.isEmpty()) return 9 * (int) Math.pow(10, n - 1);

        // Step 4: Total n-digit numbers
        int total = 9 * (int) Math.pow(10, n - 1);

        // Step 5: Count invalid numbers using digit DP
        int invalid = countInvalid(n, allowed);

        return total - invalid;
    }

    private int countInvalid(int n, List<Integer> allowed) {
        memo.clear();
        return dp(0, true, n, allowed);
    }

    private int dp(int pos, boolean isFirst, int n, List<Integer> allowed) {
        if (pos == n) return 1;

        String key = pos + "-" + isFirst;
        if (memo.containsKey(key)) return memo.get(key);

        int count = 0;
        for (int digit : allowed) {
            if (isFirst && digit == 0) continue; // Skip leading 0
            count += dp(pos + 1, false, n, allowed);
        }

        memo.put(key, count);
        return count;
    }
}
