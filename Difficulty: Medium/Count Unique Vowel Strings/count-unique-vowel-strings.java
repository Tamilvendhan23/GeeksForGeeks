class Solution {
    public int vowelCount(String s) {
        // Vowel characters
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        // Map to count occurrences of each vowel
        Map<Character, Integer> vowelFreq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelFreq.put(c, vowelFreq.getOrDefault(c, 0) + 1);
            }
        }
        
        int totalCombinations = 1;
        int uniqueVowelCount = vowelFreq.size();

        // If no vowels, return 0
        if (uniqueVowelCount == 0) return 0;
        
        // Multiply the count of each vowel (number of choices)
        for (int freq : vowelFreq.values()) {
            totalCombinations *= freq;
        }
        
        // Multiply by factorial of number of unique vowels (for permutations)
        totalCombinations *= factorial(uniqueVowelCount);
        
        return totalCombinations;
    }
    
    private int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
