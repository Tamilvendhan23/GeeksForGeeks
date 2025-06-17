import java.util.*;

class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        // Prefix sum of coins
        int[] prefix = new int[n + 1]; // prefix[0] = 0
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int total = prefix[n];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            int maxAllowed = minVal + k;

            // Binary search to find first index where arr[j] > maxAllowed
            int left = i, right = n - 1, index = n;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > maxAllowed) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Coins removed:
            int coinsRemoved = prefix[i]; // remove all before i
            int rightSum = prefix[n] - prefix[index]; // coins > maxAllowed
            int piles = n - index;
            coinsRemoved += rightSum - piles * maxAllowed;

            result = Math.min(result, coinsRemoved);
        }

        return result;
    }
}