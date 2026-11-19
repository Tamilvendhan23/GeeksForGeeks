import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int x : arr) {
            if (x % 2 == 1) {
                odd.add(x);
            } else {
                even.add(x);
            }
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);

        int i = 0;
        for (int x : odd) arr[i++] = x;
        for (int x : even) arr[i++] = x;
    }
}