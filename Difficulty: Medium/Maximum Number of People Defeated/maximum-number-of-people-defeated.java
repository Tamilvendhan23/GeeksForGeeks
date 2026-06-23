class Solution {
    int maxPeopleDefeated(int p) {
        int count = 0;
        long power = p;
        long i = 1;

        while (power >= i * i) {
            power -= i * i;
            count++;
            i++;
        }

        return count;
    }
};