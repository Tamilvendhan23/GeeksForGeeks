class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // For each character, find first and last occurrence
        for (char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            
            // If character appears more than once
            if (first != -1 && first != last) {
                int sum = 0;
                // Sum ASCII values of characters strictly between first and last
                for (int i = first + 1; i < last; i++) {
                    sum += (int) s.charAt(i);
                }
                
                // Add to result if sum is non-zero
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }
        
        return result;
    }
}
