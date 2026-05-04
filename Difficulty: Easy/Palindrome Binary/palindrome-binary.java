class Solution {
    static long isPallindrome(long N) {
        // Convert number to binary string
        String binary = Long.toBinaryString(N);
        
        // Two-pointer check for palindrome
        int left = 0, right = binary.length() - 1;
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return 0; // Not a palindrome
            }
            left++;
            right--;
        }
        
        return 1; // Palindrome
    }
}
