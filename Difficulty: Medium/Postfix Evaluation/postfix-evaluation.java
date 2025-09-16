class Solution {
    public int evaluatePostfix(String[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String token : arr) {
            if (isOperator(token)) {
                // Pop two operands in correct order
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        // Division should be integer floor division
                        result = floorDiv(a, b);
                        break;
                    case "^":
                        // Exponentiation
                        result = (int) Math.pow(a, b);
                        break;
                }
                stack.push(result);
            } else {
                // Operand, parse as integer
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
    
    // Correct floor division for positive and negative numbers
    private int floorDiv(int a, int b) {
        int div = a / b;
        int rem = a % b;
        // If the remainder is not zero and the signs differ, subtract 1 from result
        if (rem != 0 && ((a < 0) ^ (b < 0)))
            div--;
        return div;
    }
}
