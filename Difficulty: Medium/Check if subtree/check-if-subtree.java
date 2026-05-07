class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // If root2 is null, it is always a subtree
        if (root2 == null)
            return true;

        // If root1 is null but root2 is non‑null, no subtree possible
        if (root1 == null)
            return false;

        // Check if current node can be root of identical subtree
        if (areIdentical(root1, root2))
            return true;

        // Otherwise, recursively check left and right subtrees of root1
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    // Utility: check if two trees are identical
    private boolean areIdentical(Node r1, Node r2) {
        // Both null → identical
        if (r1 == null && r2 == null)
            return true;

        // One null and other not → not identical
        if (r1 == null || r2 == null)
            return false;

        // Values must match and their left/right subtrees must be identical
        return r1.data == r2.data
               && areIdentical(r1.left, r2.left)
               && areIdentical(r1.right, r2.right);
    }
}