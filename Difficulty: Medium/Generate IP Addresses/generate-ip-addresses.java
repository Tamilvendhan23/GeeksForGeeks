class Solution {
    private List<String> result = new ArrayList<>();
    private List<String> current = new ArrayList<>();
    
    public ArrayList<String> generateIp(String s) {
        backtrack(s, 0);
        return new ArrayList<>(result);
    }
    
    private void backtrack(String s, int start) {
        int n = s.length();
        
        // Base case: used all chars and have 4 segments
        if (start == n && current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }
        
        // Prune if exceeded length or too many segments
        if (start >= n || current.size() >= 4) {
            return;
        }
        
        // Try 1-3 digits segments
        for (int end = start; end < Math.min(start + 3, n); end++) {
            String segment = s.substring(start, end + 1);
            
            // Check validity: no leading zero unless single 0, and <=255
            if ((segment.startsWith("0") && segment.length() > 1) || 
                Integer.parseInt(segment) > 255) {
                continue;
            }
            
            current.add(segment);
            backtrack(s, end + 1);
            current.remove(current.size() - 1);
        }
    }
}
