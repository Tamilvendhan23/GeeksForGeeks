/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        if (root == null) return null;

        // Recursively fix left and right subtrees first
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        // If root data is less than l, return the right subtree
        if (root.data < l) {
            return root.right;
        }

        // If root data is greater than r, return the left subtree
        if (root.data > r) {
            return root.left;
        }

        // Root is in range, return root
        return root;
    }
}
