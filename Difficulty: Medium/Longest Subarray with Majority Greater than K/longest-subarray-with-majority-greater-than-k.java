// overwrite by feb 25 
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        java.util.Map<Integer, Integer> mp = new java.util.HashMap<>();
        int ans = 0;
        int sum = 0;
        
        for (int i = 0; i < n; ++i) {
            // Treat elements <= k as -1, elements > k as +1
            if (arr[i] <= k) {
                sum--;
            } else {
                sum++;
            }
            
            // If overall sum is positive, entire prefix is valid
            if (sum > 0) {
                ans = i + 1;
            } else {
                // Check if there was a prefix with sum = current_sum - 1
                if (mp.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - mp.get(sum - 1));
                }
            }
            
            // Store the first occurrence of each prefix sum
            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }
        
        return ans;
    }
}
