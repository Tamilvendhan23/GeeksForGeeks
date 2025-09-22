class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n]; // Previous smaller
        int[] right = new int[n]; // Next smaller
        Stack<Integer> s = new Stack<>();
        
        
        // Fill elements of left[]
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        
        // Reset stack for right[]
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len - 1] = Math.max(ans[len - 1], arr[i]);
        }
        
        // Fill rest elements
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : ans) res.add(x);
        return res;
    }
}
