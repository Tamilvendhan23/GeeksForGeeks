import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of array a
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Check elements of b
        for (int x : b) {
            if (!freq.containsKey(x) || freq.get(x) == 0) {
                return false;
            }
            freq.put(x, freq.get(x) - 1);
        }

        return true;
    }
}
