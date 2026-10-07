class Solution {
    int maxSum;

    public int maxPathSum(Node root) {
        if (root == null) {
            return -1;
        }

        maxSum = Integer.MIN_VALUE;
        maxRootToLeafSum(root);

        // Fewer than two leaves
        if (leafCount(root) < 2) {
            return -1;
        }

        return maxSum;
    }

    private int maxRootToLeafSum(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        // Leaf node
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Only right child exists
        if (node.left == null) {
            return node.data + maxRootToLeafSum(node.right);
        }

        // Only left child exists
        if (node.right == null) {
            return node.data + maxRootToLeafSum(node.left);
        }

        int leftSum = maxRootToLeafSum(node.left);
        int rightSum = maxRootToLeafSum(node.right);

        // A valid leaf-to-leaf path exists only when both children exist
        maxSum = Math.max(maxSum, leftSum + node.data + rightSum);

        // Return the best path from this node to one leaf
        return node.data + Math.max(leftSum, rightSum);
    }

    private int leafCount(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return leafCount(node.left) + leafCount(node.right);
    }
}