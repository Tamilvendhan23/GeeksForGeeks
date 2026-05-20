class Solution {
    public boolean isProduct(int[] arr, long target) {
        int n = arr.length;
        // Fast path: if target == 0, need at least one zero and any other element (including another zero)
        if (target == 0) {
            int zeroCount = 0;
            for (int v : arr) if (v == 0) zeroCount++;
            return zeroCount >= 1 && (zeroCount >= 2 || n >= 2);
        }

        // For non-zero target: look for a pair (a, b) where b = target / a and target % a == 0
        // Use a HashMap to store counts so we can handle duplicates correctly.
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int v : arr) freq.put((long)v, freq.getOrDefault((long)v, 0) + 1);

        for (long a : freq.keySet()) {
            if (a == 0) continue; // target != 0 so skip zeros
            if (target % a != 0) continue;
            long b = target / a;
            if (!freq.containsKey(b)) continue;
            if (a == b) {
                // need at least two occurrences of a
                if (freq.get(a) >= 2) return true;
            } else {
                return true;
            }
        }
        return false;
    }
}