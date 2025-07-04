import java.util.*;

class Solution {
    public int countAtMostK(int[] arr, int k) {
        int left = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            if (freq.size() > k) {
                while (freq.size() > k) {
                    freq.put(arr[left], freq.get(arr[left]) - 1);
                    if (freq.get(arr[left]) == 0) {
                        freq.remove(arr[left]);
                    }
                    left++;
                }
            }

            res += right - left + 1; // Count subarrays ending at right
        }

        return res;
    }
}
