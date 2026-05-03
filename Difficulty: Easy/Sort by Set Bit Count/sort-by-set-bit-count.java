import java.util.*;

class Solution {
    public ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));

        return new ArrayList<>(Arrays.asList(temp));
    }
}