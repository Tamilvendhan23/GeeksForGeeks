import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(prices);  // sort ascending
        
        int n = prices.length;
        
        // Minimum cost calculation
        int minCost = 0;
        int i = 0; // start from cheapest
        int j = n - 1; // end pointer for free candies
        while (i <= j) {
            minCost += prices[i]; // buy cheapest
            i++; // move to next cheapest
            j -= k; // skip k most expensive for free
        }
        
        // Maximum cost calculation
        int maxCost = 0;
        i = n - 1; // start from most expensive
        j = 0; // start pointer for free candies
        while (i >= j) {
            maxCost += prices[i]; // buy expensive
            i--; // move to next expensive
            j += k; // skip k cheapest for free
        }
        
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
