import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        final int MOD = 1000000007;

        // Max-heap for ticket prices
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            pq.offer(x);
        }

        long amount = 0;

        // Sell at most k tickets
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break; // no more tickets

            int price = pq.poll();   // highest available price
            amount = (amount + price) % MOD;

            if (price - 1 > 0) {
                pq.offer(price - 1); // remaining ticket from this seller
            }
        }

        return (int) (amount % MOD);
    }
}