class Solution {
    public int minDiff(Node root, int k) {
        int ans = Integer.MAX_VALUE;
        Node curr = root;

        while (curr != null) {
            ans = Math.min(ans, Math.abs(curr.data - k));

            if (curr.data == k) {
                return 0;
            } else if (k < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return ans;
    }
}