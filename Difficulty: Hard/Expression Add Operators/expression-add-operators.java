import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        backtrack(result, "", s, target, 0, 0, 0);
        Collections.sort(result);
        return result;
    }

    // pos: current position in input string s
    // expr: current expression string being built
    // evaluated: current evaluated result for expr
    // multed: last operand (needed for multiplication cases)
    private void backtrack(ArrayList<String> result, String expr, String s, int target, int pos, long evaluated, long multed) {
        if (pos == s.length()) {
            if (evaluated == target) {
                result.add(expr);
            }
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            // Skip numbers with leading zero
            if (i != pos && s.charAt(pos) == '0') break;
            String curStr = s.substring(pos, i + 1);
            long curNum = Long.parseLong(curStr);

            if (pos == 0) {
                // First number, pick it without operator
                backtrack(result, curStr, s, target, i + 1, curNum, curNum);
            } else {
                backtrack(result, expr + "+" + curStr, s, target, i + 1, evaluated + curNum, curNum);
                backtrack(result, expr + "-" + curStr, s, target, i + 1, evaluated - curNum, -curNum);
                // multiplication: subtract previous multed, add multed*curNum
                backtrack(result, expr + "*" + curStr, s, target, i + 1, evaluated - multed + multed * curNum, multed * curNum);
            }
        }
    }
}
