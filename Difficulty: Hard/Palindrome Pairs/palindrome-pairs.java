class Solution {
    public boolean palindromePair(String[] arr) {
        if (arr == null || arr.length < 2) return false;
        
        java.util.Map<String, Integer> revToIndex = new java.util.HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            revToIndex.put(new StringBuilder(arr[i]).reverse().toString(), i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            // Case 1: empty string + palindrome
            if (revToIndex.containsKey("") && revToIndex.get("") != i && isPalindrome(word)) {
                return true;
            }
            // Case 2: prefix match
            for (int j = 1; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (revToIndex.containsKey(left) && revToIndex.get(left) != i && isPalindrome(right)) {
                    return true;
                }
                if (revToIndex.containsKey(right) && revToIndex.get(right) != i && isPalindrome(left)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}