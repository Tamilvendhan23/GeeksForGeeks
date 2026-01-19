class Solution {
    public String removeKdig(String s, int k) {
        java.util.Stack<Character> st = new java.util.Stack<>();
        
        for (char c : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            if (!st.isEmpty() || c != '0') {
                st.push(c);
            }
        }
        
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        if (st.isEmpty()) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}
