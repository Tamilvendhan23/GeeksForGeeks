import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqToNums = new TreeMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            // Remove from old frequency
            if (freqMap.containsKey(num)) {
                int oldFreq = freqMap.get(num);
                freqToNums.get(oldFreq).remove(num);
                if (freqToNums.get(oldFreq).isEmpty()) {
                    freqToNums.remove(oldFreq);
                }
                freqMap.put(num, oldFreq + 1);
            } else {
                freqMap.put(num, 1);
            }
            
            // Add to new frequency
            int newFreq = freqMap.get(num);
            freqToNums.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(num);
            
            // Remove leftmost element if window exceeds size k
            if (i >= k) {
                int outNum = arr[i - k];
                int outFreq = freqMap.get(outNum);
                freqToNums.get(outFreq).remove(outNum);
                if (freqToNums.get(outFreq).isEmpty()) {
                    freqToNums.remove(outFreq);
                }

                if (outFreq == 1) {
                    freqMap.remove(outNum);
                } else {
                    freqMap.put(outNum, outFreq - 1);
                    freqToNums.computeIfAbsent(outFreq - 1, x -> new TreeSet<>()).add(outNum);
                }
            }
            
            // Add mode to sum if window size is k
            if (i >= k - 1) {
                int maxFreq = freqToNums.lastKey();
                int mode = freqToNums.get(maxFreq).first();
                sum += mode;
            }
        }
        return sum;
    }
}
