class Solution {
    static String decodeString(String s) {
        java.util.Stack<Integer> numStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> strStack = new java.util.Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // For numbers > 9
            } else if (c == '[') {
                numStack.push(num);      // Push current number
                strStack.push(curr);     // Push current string
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeat = numStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                curr = prev;
            } else {
                curr.append(c);           
            }
        }
        return curr.toString();
    }
}
