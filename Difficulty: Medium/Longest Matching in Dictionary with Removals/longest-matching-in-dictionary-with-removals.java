import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length();

        int[][] next = new int[n + 1][26];

        Arrays.fill(next[n], -1);

        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(next[i + 1], 0, next[i], 0, 26);
            next[i][s.charAt(i) - 'a'] = i;
        }

        String answer = "";

        for (String word : d) {
            if (canForm(word, next, n)) {
                if (word.length() > answer.length()
                        || (word.length() == answer.length()
                        && word.compareTo(answer) < 0)) {
                    answer = word;
                }
            }
        }

        return answer;
    }

    private boolean canForm(String word, int[][] next, int n) {
        int position = 0;

        for (int i = 0; i < word.length(); i++) {
            int character = word.charAt(i) - 'a';

            if (position > n || next[position][character] == -1) {
                return false;
            }

            position = next[position][character] + 1;
        }

        return true;
    }
}