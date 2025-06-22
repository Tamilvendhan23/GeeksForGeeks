import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();
        
        // Sort the array first
        Arrays.sort(arr);
        
        // dp[i] = length of longest divisible subset ending at index i
        int[] dp = new int[n];
        // Store all possible parents for each position
        List<List<Integer>> allParents = new ArrayList<>();
        
        // Initialize
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            allParents.add(new ArrayList<>());
            allParents.get(i).add(-1); // Each element can form a subset by itself
        }
        
        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        allParents.get(i).clear();
                        allParents.get(i).add(j);
                    } else if (dp[j] + 1 == dp[i]) {
                        allParents.get(i).add(j);
                    }
                }
            }
        }
        
        // Find maximum length
        int maxLen = Arrays.stream(dp).max().orElse(1);
        
        // Generate all possible maximum length subsets
        List<ArrayList<Integer>> allMaxSubsets = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                generateAllSubsets(arr, allParents, i, new ArrayList<>(), allMaxSubsets);
            }
        }
        
        // Find lexicographically greatest
        ArrayList<Integer> bestSubset = allMaxSubsets.get(0);
        for (int i = 1; i < allMaxSubsets.size(); i++) {
            if (isLexGreater(allMaxSubsets.get(i), bestSubset)) {
                bestSubset = allMaxSubsets.get(i);
            }
        }
        
        return bestSubset;
    }
    
    // Generate all possible subsets ending at position idx
    private void generateAllSubsets(int[] arr, List<List<Integer>> allParents, 
                                   int idx, ArrayList<Integer> current, 
                                   List<ArrayList<Integer>> result) {
        current.add(0, arr[idx]); // Add at beginning
        
        if (allParents.get(idx).get(0) == -1) {
            // Base case: no parent
            result.add(new ArrayList<>(current));
        } else {
            // Try all possible parents
            for (int parent : allParents.get(idx)) {
                if (parent != -1) {
                    generateAllSubsets(arr, allParents, parent, current, result);
                }
            }
        }
        
        current.remove(0); // Backtrack
    }
    
    // Helper function to compare lexicographically
    private boolean isLexGreater(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (a.get(i) > b.get(i)) return true;
            if (a.get(i) < b.get(i)) return false;
        }
        return false;
    }
}