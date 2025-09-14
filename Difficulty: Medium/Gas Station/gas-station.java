class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int start = 0, tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            // If tank is negative, reset start to i+1
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return (totalGas >= totalCost) ? start : -1;
    }
}
