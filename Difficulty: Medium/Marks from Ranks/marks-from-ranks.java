class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;

        // prefix[i] = total number of valid marks up to interval i (0-based)
        int[] prefix = new int[n];
        prefix[0] = r[0] - l[0] + 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int q : rank) {
            // Binary search: find first interval where prefix[idx] >= q
            int low = 0, high = n - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (prefix[mid] < q) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int idx = low;

            // Number of marks from the end of this interval to the target rank
            int diff = prefix[idx] - q;
            int mark = r[idx] - diff;

            ans.add(mark);
        }

        return ans;
    }
}