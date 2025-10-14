class Solution {
    public int nodeSum(Node root, int l, int r) {
        if (root == null) return 0;
        
        // If current node’s value is smaller than l, only right subtree might have values in range
        if (root.data < l)
            return nodeSum(root.right, l, r);
        
        // If current node’s value is greater than r, only left subtree might have values in range
        else if (root.data > r)
            return nodeSum(root.left, l, r);
        
        // Current node is in range, include its value and check both subtrees
        else
            return root.data + nodeSum(root.left, l, r) + nodeSum(root.right, l, r);
    }
}
