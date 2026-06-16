class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);  // Initial value
        
        int xorr = 0;  // Cumulative XOR
        
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            
            if (type == 1) {
                // XOR query: update cumulative XOR
                xorr ^= x;
            } else {
                // Insert query: add x XORed with cumulative XOR
                ans.add(xorr ^ x);
            }
        }
        
        // Apply final cumulative XOR to all elements
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) ^ xorr);
        }
        
        // Sort and return
        Collections.sort(ans);
        return ans;
    }
}