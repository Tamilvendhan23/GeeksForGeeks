import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        HashSet<Integer> st = new HashSet<>();
        for (int num : arr) {
            st.add(num);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long a = arr[i];
                long b = arr[j];
                long sumSq = a * a + b * b;
                long c = (long) Math.sqrt(sumSq);
                if (c * c == sumSq && st.contains((int) c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
