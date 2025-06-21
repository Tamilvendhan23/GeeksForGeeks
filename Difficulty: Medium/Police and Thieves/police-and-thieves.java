import java.util.*;

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();
        
        // Store indices of 'P' and 'T'
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thief.add(i);
            }
        }

        int i = 0, j = 0, count = 0;
        
        // Greedy matching
        while (i < police.size() && j < thief.size()) {
            if (Math.abs(police.get(i) - thief.get(j)) <= k) {
                count++;
                i++;
                j++;
            } else if (thief.get(j) < police.get(i)) {
                j++;
            } else {
                i++;
            }
        }

        return count;
    }
}
