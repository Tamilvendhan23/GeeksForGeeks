class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n < 2) return 0;

        // Manacher for odd-length palindromes: radius[i] = number of chars including center
        int[] oddRadius = manacherOdd(s);

        // endMax[i] = max odd-palindrome length that ends exactly at index i
        // startMax[i] = max odd-palindrome length that starts exactly at index i
        int[] endMax = new int[n];
        int[] startMax = new int[n];

        // Record the maximal palindrome (for each center) at its extreme start and end
        for (int center = 0; center < n; center++) {
            int rad = oddRadius[center];               // rad >= 1
            int len = 2 * rad - 1;                    // odd palindrome length
            int start = center - (rad - 1);
            int end = center + (rad - 1);
            if (start >= 0) startMax[start] = Math.max(startMax[start], len);
            if (end < n)    endMax[end]     = Math.max(endMax[end], len);
        }

        // Propagate backwards to fill endMax for palindromes that end earlier (L-2 relation)
        for (int i = n - 2; i >= 0; i--) {
            int cand = endMax[i + 1] - 2;
            if (cand > endMax[i]) endMax[i] = cand;
        }
        // Propagate forwards to fill startMax for palindromes that start later (L-2 relation)
        for (int i = 1; i < n; i++) {
            int cand = startMax[i - 1] - 2;
            if (cand > startMax[i]) startMax[i] = cand;
        }

        // Build prefix maximum of best palindrome fully inside s[0..i]
        int[] leftMax = new int[n];
        leftMax[0] = endMax[0]; // best palindrome ending at 0
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], endMax[i]);
        }

        // Build suffix maximum of best palindrome fully inside s[i..n-1]
        int[] rightMax = new int[n];
        rightMax[n - 1] = startMax[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], startMax[i]);
        }

        // Try all split points between i and i+1
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
        }
        return ans;
    }

    // Manacher for odd-length palindromes: returns radius array (k) where palindrome length = 2*k-1
    private int[] manacherOdd(String s) {
        int n = s.length();
        int[] radius = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(radius[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            radius[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return radius;
    }
}
