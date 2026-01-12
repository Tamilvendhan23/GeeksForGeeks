class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        // Process first k elements
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        result.add(arr[dq.peekFirst()]);

        
        // Process remaining elements
        for (int i = k; i < arr.length; i++) {
            // Remove elements out of current window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            
            // Remove smaller elements from back
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
            result.add(arr[dq.peekFirst()]);
        }
        
        return result;
    }
}
