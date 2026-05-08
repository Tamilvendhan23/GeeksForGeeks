class Solution {
    public List<String> validParenthesis(String s) {
        List<String> result = new ArrayList<>();
        Set<String> st = new HashSet<>();

        // to store count of invalid
        // open and closed parenthesis
        int open = 0, close = 0;
        
        for (char c : s.toCharArray()) {
            
            // if open bracket, increase
            // open invalid count by 1
            if (c == '(')
                open++;
            else if (c == ')') {
                
                // decrement invalid open
                // count by 1 if open is not 0
                if (open != 0)
                    open--;
                    
                // else increment invalid close
                // bracket count by 1
                else
                    close++;
            }
        }

        // recursive function to find all valid strings
        findValid(s, 0, open, close, 0, "", result, st);
        return result;
    }
    
    // Helper recursive function to find all valid strings
    private void findValid(String str, int index, int open,
                          int close, int pair, String cur,
                          List<String> res, Set<String> st)
    {
        // base case, if end of string is reached
        if (index == str.length()) {

            // check if all open and closed invalid
            // parenthesis are removed and no pair is left
            if (open == 0 && close == 0 && pair == 0) {

                // check if cur is present in the set
                if (!st.contains(cur)) {
                    res.add(cur);
                    st.add(cur);
                }
            }
            return;
        }

        // if the current character is not a parenthesis
        if (str.charAt(index) != '('
            && str.charAt(index) != ')') {

            // add the character to the current string
            findValid(str, index + 1, open, close, pair,
                      cur + str.charAt(index), res, st);
        }
        else {

            // if the current character is an open bracket
            if (str.charAt(index) == '(') {

                // reduce open count by 1,
                // and skip current character
                if (open > 0) {
                    findValid(str, index + 1, open - 1,
                              close, pair, cur, res, st);
                }

                // add the current character to the string
                findValid(str, index + 1, open, close,
                          pair + 1, cur + str.charAt(index),
                          res, st);
            }

            // else if the current character is a closed
            // bracket
            else {

                // skip current character and
                // reduce closed count by 1
                if (close > 0)
                    findValid(str, index + 1, open,
                              close - 1, pair, cur, res,
                              st);

                // if there is an open pair, reduce
                // it and add the current character
                if (pair > 0)
                    findValid(str, index + 1, open, close,
                              pair - 1,
                              cur + str.charAt(index), res,
                              st);
            }
        }
    }
}