class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // Map each value to its sorted list of indices
        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            indexMap.putIfAbsent(arr[i], new ArrayList<>());
            indexMap.get(arr[i]).add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            // If x doesn't exist in array, frequency is 0
            if (!indexMap.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = indexMap.get(x);
            
            // Binary search for first index >= l (lower bound)
            int left = Collections.binarySearch(indices, l);
            if (left < 0) left = -(left + 1);
            
            // Binary search for first index > r (upper bound)
            int right = Collections.binarySearch(indices, r + 1);
            if (right < 0) right = -(right + 1);
            
            // Count = upper_bound - lower_bound
            result.add(right - left);
        }
        
        return result;
    }
}