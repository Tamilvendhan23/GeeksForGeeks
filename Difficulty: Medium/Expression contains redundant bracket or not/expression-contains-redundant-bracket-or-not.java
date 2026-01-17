class Solution {
    public static boolean checkRedundancy(String s) {
        java.util.Stack<Character> st = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                boolean flag = true;
                // Pop the first element after ')'
                if (!st.isEmpty()) {
                    char top = st.pop();
                    while (!st.isEmpty() && top != '(') {
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            flag = false;
                        }
                        top = st.pop();
                    }
                }
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
