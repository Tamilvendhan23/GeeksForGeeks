class Solution {
    public void toSumTree(Node root) {
        helper(root);
    }

    private int helper(Node root) {
        if (root == null) return 0;

        int oldVal = root.data;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        root.data = leftSum + rightSum;
        return oldVal + leftSum + rightSum;
    }
}