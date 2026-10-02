class Solution {
    public String lexiString(String s) {
        int n = s.length();
        if (n <= 1) return s;

        // Booth's algorithm to find the starting index of 
        // lexicographically smallest rotation
        int[] f = new int[2 * n];
        Arrays.fill(f, -1);
        int k = 0; // starting index of best rotation found so far

        for (int j = 1; j < 2 * n; j++) {
            int i = f[j - k - 1];
            char cj = s.charAt(j % n);

            while (i != -1 && cj != s.charAt((k + i + 1) % n)) {
                if (cj < s.charAt((k + i + 1) % n)) {
                    k = j - i - 1;
                }
                i = f[i];
            }

            if (cj != s.charAt((k + i + 1) % n)) {
                if (cj < s.charAt((k + i + 1) % n)) {
                    k = j;
                }
                f[j - k] = -1;
            } else {
                f[j - k] = i + 1;
            }
        }

        // Build result starting from index k
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt((k + i) % n));
        }
        return sb.toString();
    }
}