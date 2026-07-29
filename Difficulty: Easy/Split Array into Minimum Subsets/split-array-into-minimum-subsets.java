class Solution {
    int minSubsets(int arr[]) {
        // Approach 2: Hashing - O(n) time, O(n) space
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int count = 0;
        for (int x : arr) {
            // Check if x is the start of a new consecutive subset
            if (!set.contains(x - 1)) {
                count++;
            }
        }
        return count;
    }
}