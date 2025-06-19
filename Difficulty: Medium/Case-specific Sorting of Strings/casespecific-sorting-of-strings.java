class Solution {
    public String caseSort(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        
        // Lists to store uppercase and lowercase characters
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();
        
        // Separate characters based on their case
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }
        
        // Sort both lists
        Collections.sort(upper);
        Collections.sort(lower);
        
        // Indices to track position in upper and lower lists
        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        
        // Build the result string maintaining the original positions
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                result.append(upper.get(i++));
            } else {
                result.append(lower.get(j++));
            }
        }
        
        return result.toString();
    }
}
