class Solution {
    public String compress(String s) {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        int[] lps = new int[n];

        // Build the KMP LPS array
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        StringBuilder reversed = new StringBuilder();

        // Process prefixes from right to left
        for (int i = n - 1; i > 0; i--) {
            int length = i + 1;

            // A prefix with odd length cannot be split into
            // two equal halves
            if ((length & 1) == 1) {
                reversed.append(s.charAt(i));
                continue;
            }

            int longestPrefixSuffix = lps[i];
            int blockLength = length - longestPrefixSuffix;

            /*
             * The prefix is periodic and contains an even number
             * of repetitions. Therefore, its two halves are equal.
             */
            boolean canCompress =
                    longestPrefixSuffix * 2 >= length
                    && length % blockLength == 0
                    && (length / blockLength) % 2 == 0;

            if (canCompress) {
                reversed.append('*');

                // Process only the first half of this prefix
                i = length / 2;
            } else {
                reversed.append(s.charAt(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(s.charAt(0));

        while (reversed.length() > 0) {
            answer.append(reversed.charAt(reversed.length() - 1));
            reversed.setLength(reversed.length() - 1);
        }

        return answer.toString();
    }
}