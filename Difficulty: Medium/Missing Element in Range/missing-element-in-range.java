class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> present = new HashSet<>();
        
        // Add array elements in range to set
        for (int num : arr) {
            if (num >= low && num <= high) {
                present.add(num);
            }
        }
        
        // Collect missing numbers in order
        for (int i = low; i <= high; ++i) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}
