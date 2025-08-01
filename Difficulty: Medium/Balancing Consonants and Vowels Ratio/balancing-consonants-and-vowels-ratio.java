import java.util.*;

class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Integer, Integer> freq = new HashMap<>();
        
        int balance = 0;  // prefix balance
        int result = 0;
        
        freq.put(0, 1);  // base case: empty prefix
        
        for (String word : arr) {
            for (char ch : word.toCharArray()) {
                if (vowels.contains(ch)) {
                    balance++; // vowel
                } else {
                    balance--; // consonant
                }
            }
            // if we've seen this balance before, add the count
            result += freq.getOrDefault(balance, 0);
            
            // update frequency of this balance
            freq.put(balance, freq.getOrDefault(balance, 0) + 1);
        }
        
        return result;
    }
}
