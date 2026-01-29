import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String firstNonRepeating(String s) {
        int[] count = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (count[idx] == 0) {
                q.add(c);
            }
            count[idx]++;
            
            while (!q.isEmpty() && count[q.peek() - 'a'] > 1) {
                q.poll();
            }
            
            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append('#');
            }
        }
        return ans.toString();
    }
}
