class Solution {
    public int validGroups(String s) {
        int n = s.length();
        int maxSum = n * 9;
        int[][] memo = new int[n + 1][maxSum + 1];
        
        // Initialize memo table with -1
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        
        return countWays(s, 0, 0, memo);
    }
    
    private int countWays(String s, int index, int prevSum, int[][] memo) {
        // Base case: reached the end of string
        if (index == s.length()) {
            return 1;
        }
        
        // Return memoized result if already computed
        if (memo[index][prevSum] != -1) {
            return memo[index][prevSum];
        }
        
        int currSum = 0;
        int total = 0;
        
        // Try all possible substrings starting from index
        for (int i = index; i < s.length(); i++) {
            currSum += s.charAt(i) - '0';
            
            // Only proceed if current sum >= previous sum (non-decreasing)
            if (currSum >= prevSum) {
                total += countWays(s, i + 1, currSum, memo);
            }
        }
        
        // Memoize and return
        memo[index][prevSum] = total;
        return total;
    }
}