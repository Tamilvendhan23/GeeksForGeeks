class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1); // empty prefix

        int sum = 0;
        int longest = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Java's % can return a negative value for negative sums
            int rem = ((sum % k) + k) % k;

            if (firstIndex.containsKey(rem)) {
                longest = Math.max(longest, i - firstIndex.get(rem));
            } else {
                firstIndex.put(rem, i);
            }
        }

        return longest;
    }
}