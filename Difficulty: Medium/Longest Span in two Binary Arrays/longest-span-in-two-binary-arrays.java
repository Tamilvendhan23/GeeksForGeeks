import java.util.HashMap;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        
        int sum1 = 0, sum2 = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            int diff = sum1 - sum2;

            if (diff == 0) {
                maxLen = i + 1;
            } else if (firstIndex.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(diff));
            } else {
                firstIndex.put(diff, i);
            }
        }
        return maxLen;
    }
}