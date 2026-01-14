class Solution {
    public int catchThieves(char[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
            else thieves.add(i);
        }

        int i = 0, j = 0, count = 0;

        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                count++;
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}
