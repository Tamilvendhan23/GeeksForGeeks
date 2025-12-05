class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        
        int k = costs[0].length;
        if (k == 0) return -1;
        
        // prevMinCost and prevSecondMinCost for previous wall
        int prevMinCost = Integer.MAX_VALUE / 2;
        int prevSecondMinCost = Integer.MAX_VALUE / 2;
        int prevMinColor = -1;
        
        // Process first wall
        for (int j = 0; j < k; j++) {
            if (costs[0][j] < prevMinCost) {
                prevSecondMinCost = prevMinCost;
                prevMinCost = costs[0][j];
                prevMinColor = j;
            } else if (costs[0][j] < prevSecondMinCost) {
                prevSecondMinCost = costs[0][j];
            }
        }
        
        // Process remaining walls
        for (int i = 1; i < n; i++) {
            int currMinCost = Integer.MAX_VALUE / 2;
            int currSecondMinCost = Integer.MAX_VALUE / 2;
            int currMinColor = -1;
            
            for (int j = 0; j < k; j++) {
                int prevCost;
                if (j == prevMinColor) {
                    prevCost = prevSecondMinCost;
                } else {
                    prevCost = prevMinCost;
                }
                
                int totalCost = (prevCost == Integer.MAX_VALUE / 2 ? Integer.MAX_VALUE / 2 : 
                               prevCost + costs[i][j]);
                
                if (totalCost < currMinCost) {
                    currSecondMinCost = currMinCost;
                    currMinCost = totalCost;
                    currMinColor = j;
                } else if (totalCost < currSecondMinCost) {
                    currSecondMinCost = totalCost;
                }
            }
            
            prevMinCost = currMinCost;
            prevSecondMinCost = currSecondMinCost;
            prevMinColor = currMinColor;
        }
        
        return prevMinCost == Integer.MAX_VALUE / 2 ? -1 : prevMinCost;
    }
}
