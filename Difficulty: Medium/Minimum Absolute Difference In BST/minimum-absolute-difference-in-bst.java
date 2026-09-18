/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff;
    private Integer prev;  // use Integer to allow null

    public int absDiff(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inorder(node.left);

        // Process current node
        if (prev != null) {
            int diff = node.data - prev;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        prev = node.data;

        // Traverse right subtree
        inorder(node.right);
    }
}