import java.util.*;

class Solution {
    public String longestString(String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        
        Arrays.sort(arr, (a, b) -> {
            if (b.length() != a.length()) {
                return b.length() - a.length();  // Sort by length descending
            }
            return a.compareTo(b);  // Then lexicographically
        });

        for (String word : arr) {
            boolean valid = true;
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return word;
            }
        }

        return "";
    }
}
