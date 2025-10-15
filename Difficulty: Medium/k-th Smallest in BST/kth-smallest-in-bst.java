class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(Node node, int k) {
        if (node == null) return;

        // Traverse left subtree
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.data;
            return; // stop further traversal
        }

        // Traverse right subtree
        inorder(node.right, k);
    }
}
