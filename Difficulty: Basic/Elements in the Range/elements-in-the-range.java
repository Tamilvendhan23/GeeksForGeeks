class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        
        // Insert all array elements into the set
        for (int x : arr) {
            set.add(x);
        }
        
        // Check each value in [start, end]
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        
        return true;
    }
}