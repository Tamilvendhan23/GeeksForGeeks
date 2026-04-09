class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < a.length && j < b.length) {
            // Skip duplicates in a[]
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // a[i] == b[j]: common distinct element
                result.add(a[i]);
                i++;
                j++;
            }
        }
        
        return result;
    }
}