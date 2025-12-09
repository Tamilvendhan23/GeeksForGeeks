class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);      // original value
            int idx = val - 1;               // mapped index 0..n-1

            if (arr[idx] < 0) {
                // already visited once -> duplicate
                ans.add(val);
            } else {
                // first visit -> mark as visited
                arr[idx] = -arr[idx];
            }
        }

        return ans;  // driver will sort if needed
    }
}
