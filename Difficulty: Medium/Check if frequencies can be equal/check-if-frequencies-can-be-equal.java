import java.util.*;

class Solution {
    public boolean sameFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Count how many times each frequency occurs
        for (int f : freq.values()) {
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        // Case 1: All frequencies same
        if (freqCount.size() == 1) {
            return true;
        }

        // Case 2: Exactly two different frequencies
        if (freqCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = freqCount.entrySet().iterator();
            Map.Entry<Integer, Integer> entry1 = it.next();
            Map.Entry<Integer, Integer> entry2 = it.next();

            int f1 = entry1.getKey(), c1 = entry1.getValue();
            int f2 = entry2.getKey(), c2 = entry2.getValue();

            // Try removing one character with frequency 1 or reduce frequency by 1
            if ((c1 == 1 && (f1 - 1 == f2 || f1 - 1 == 0)) ||
                (c2 == 1 && (f2 - 1 == f1 || f2 - 1 == 0))) {
                return true;
            }
        }

        return false;
    }
}
