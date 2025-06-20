import java.util.*;

class Solution {
    public boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!map.containsKey(current)) return false;

                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
            }
        }
        return true;
    }
}
