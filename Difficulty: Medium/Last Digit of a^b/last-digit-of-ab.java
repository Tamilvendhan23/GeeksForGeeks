class Solution {
    public int getLastDigit(String a, String b) {
        // Get the last digit of base a
        int lastDigitA = a.charAt(a.length() - 1) - '0';
        
        // Handle special cases
        if (lastDigitA == 0) return 0;
        if (lastDigitA == 1) return 1;
        if (lastDigitA == 5) return 5;
        if (lastDigitA == 6) return 6;
        
        // Get the last 2 digits of exponent b (to handle b%4)
        int lastDigitB = b.charAt(b.length() - 1) - '0';
        int exponent;
        
        if (b.length() == 1) {
            exponent = lastDigitB;
        } else {
            int secondLastDigitB = b.charAt(b.length() - 2) - '0';
            exponent = secondLastDigitB * 10 + lastDigitB;
        }
        
        // Handle b = 0 case
        if (exponent == 0 && b.length() > 1 || (b.length() == 1 && lastDigitB == 0)) {
            if (b.equals("0")) return 1;
        }
        
        // The last digit of a^b cycles with period 4
        // So we need (lastDigitA)^(exponent % 4), but if exponent%4==0, use 4
        int cycle = exponent % 4;
        if (cycle == 0) cycle = 4;
        
        // Calculate (lastDigitA)^cycle % 10
        int result = 1;
        for (int i = 0; i < cycle; i++) {
            result = (result * lastDigitA) % 10;
        }
        
        return result;
    }
};