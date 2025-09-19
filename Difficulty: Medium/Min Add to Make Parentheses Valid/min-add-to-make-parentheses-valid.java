class Solution {
    public int minParentheses(String s) {
        int open = 0;    // Unmatched '(' count
        int insertions = 0; // Insertions needed for unmatched ')'
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                open++;    // An opening bracket needs a match
            } else { // ch == ')'
                if(open > 0) {
                    open--; // Found a match for a previous '('
                } else {
                    insertions++; // No opening bracket to match, so need to insert '('
                }
            }
        }
        // Add unmatched openings to the required insertions
        return open + insertions;
    }
}
