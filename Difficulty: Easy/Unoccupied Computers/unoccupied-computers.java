class Solution {
    public int solve(int n, String s) {
        boolean[] inCafe = new boolean[26];      // is customer currently in cafe?
        boolean[] hasComputer = new boolean[26]; // did this customer get a computer?
        int occupied = 0;
        int rejected = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'A';

            if (!inCafe[idx]) {
                // Arrival
                inCafe[idx] = true;
                if (occupied < n) {
                    occupied++;
                    hasComputer[idx] = true;
                } else {
                    rejected++;
                    hasComputer[idx] = false;
                }
            } else {
                // Departure
                inCafe[idx] = false;
                if (hasComputer[idx]) {
                    occupied--;
                }
            }
        }

        return rejected;
    }
}