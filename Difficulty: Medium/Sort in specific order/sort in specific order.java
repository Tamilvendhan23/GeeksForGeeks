import java.util.Arrays;

class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;
        
        // Step 1: make all odd elements negative
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1) {   // odd numbers
                arr[i] = -arr[i];
            }
        }
        
        // Step 2: sort the whole array
        Arrays.sort(arr);
        
        // Step 3: make all negative elements positive again (they are the odds)
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }
    }
}




