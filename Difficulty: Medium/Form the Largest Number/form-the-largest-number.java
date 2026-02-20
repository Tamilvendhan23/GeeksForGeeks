import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        String[] strs = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strs[i] = String.valueOf(arr[i]);
        }
        
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        
        if (strs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
