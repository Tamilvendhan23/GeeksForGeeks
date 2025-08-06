class Solution {
    public int romanToDecimal(String s) {
        // Map Roman numerals to their integer values
        int map[] = new int[26]; // For 'A' to 'Z'
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        
        int n = s.length();
        int total = 0;
        
        for(int i = 0; i < n; i++) {
            int value = map[s.charAt(i) - 'A'];
            // Check if next value is greater
            if(i+1 < n && map[s.charAt(i+1) - 'A'] > value) {
                total -= value;
            } else {
                total += value;
            }
        }
        return total;
    }
}
