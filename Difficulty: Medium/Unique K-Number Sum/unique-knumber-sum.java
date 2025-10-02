class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Helper function to perform backtracking
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int start, int target, int k, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // If combination length is k and target is 0, add to result
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // If exceeded constraints, don't proceed
        if (current.size() > k || target < 0) {
            return;
        }
        // Try each number from start to 9
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, target - i, k, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
