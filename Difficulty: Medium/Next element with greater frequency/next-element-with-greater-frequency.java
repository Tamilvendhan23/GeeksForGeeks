class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Build frequency map
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && freq.get(arr[st.peek()]) <= freq.get(arr[i])) {
                st.pop();
            }
            if (st.isEmpty()) {
                result.add(-1);
            } else {
                result.add(arr[st.peek()]);
            }
            st.push(i);
        }
        
        // Reverse the result since we built it from right to left
        Collections.reverse(result);
        return result;
    }
}
