class Solution {
    public int maxProfit(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int hold = -arr[0];  // Hold a stock: expect to buy on first day
        int sold = 0;        // Sold a stock (cannot buy next day)
        int rest = 0;        // Cooldown (resting, no action)

        for (int i = 1; i < n; i++) {
            int prev_hold = hold;
            int prev_sold = sold;
            int prev_rest = rest;

            // If holding today, either we held yesterday or we bought today (after rest)
            hold = Math.max(prev_hold, prev_rest - arr[i]);
            
            // If sold today, must have held yesterday and sell today
            sold = prev_hold + arr[i];
            
            // If resting today, either we were in rest yesterday or we just sold yesterday
            rest = Math.max(prev_rest, prev_sold);
        }
        // Maximum profit cannot be with an active holding at end; choose max of sold and rest
        return Math.max(sold, rest);
    }
}
