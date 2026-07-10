class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int n = arr.length;
        
        // freq[r] = how many numbers have remainder r when divided by k
        int[] freq = new int[k];
        for (int x : arr) {
            int r = x % k;
            freq[r]++;
        }

        long count = 0; // use long to avoid overflow for large counts

        // 1) Pairs where both elements have remainder 0
        // number of ways to choose 2 from freq[0] = freq[0] * (freq[0] - 1) / 2
        count += (long) freq[0] * (freq[0] - 1) / 2;

        // 2) Pairs with remainder i and k-i
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            count += (long) freq[i] * freq[k - i];
        }

        // 3) If k is even, handle the remainder k/2 similarly to remainder 0
        if (k % 2 == 0) {
            count += (long) freq[k / 2] * (freq[k / 2] - 1) / 2;
        }

        return (int) count;
    }
}