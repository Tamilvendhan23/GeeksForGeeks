class Solution {
    public int getSize(Node root) {
        // Base case: if the tree is empty, return 0
        if (root == null) {
            return 0;
        }
        
        // Recursive case: size = 1 + size of left subtree + size of right subtree
        return 1 + getSize(root.left) + getSize(root.right);
    }
}