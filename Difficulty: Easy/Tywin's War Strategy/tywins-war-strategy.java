import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2; // ceil(n/2)
        List<Integer> costs = new ArrayList<>();
        
        int luckyCount = 0;
        for (int soldiers : arr) {
            int remainder = soldiers % k;
            int cost = (k - remainder) % k;
            if (cost == 0) {
                luckyCount++;
            } else {
                costs.add(cost);
            }
        }
        
        if (luckyCount >= required) {
            return 0;
        }
        
        Collections.sort(costs);
        int soldiersNeeded = 0;
        int need = required - luckyCount;
        
        for (int i = 0; i < need; i++) {
            soldiersNeeded += costs.get(i);
        }
        
        return soldiersNeeded;
    }
}
