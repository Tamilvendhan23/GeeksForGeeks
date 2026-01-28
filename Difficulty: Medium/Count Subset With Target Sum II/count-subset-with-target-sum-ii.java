class Solution {
    public int countSubset(int[] arr, int k) {
        long minSum = 0, maxSum = 0;

        for (int x : arr) {
            if (x < 0) minSum += x;
            else maxSum += x;
        }

        // Early impossible cases
        if (k < minSum || k > maxSum) return 0;

        // Only now DP is meaningful
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : arr) {
            Map<Integer, Integer> next = new HashMap<>(dp);

            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                int s = e.getKey() + num;
                next.put(s, next.getOrDefault(s, 0) + e.getValue());
            }
            dp = next;
        }

        return dp.getOrDefault(k, 0);
    }
}
