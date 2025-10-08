/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex = 0;

    public Node constructTree(int[] pre, int[] post) {
        return construct(pre, post, 0, post.length - 1);
    }

    private Node construct(int[] pre, int[] post, int l, int h) {
        // Base cases
        if (preIndex >= pre.length || l > h)
            return null;

        // Create the current root node
        Node root = new Node(pre[preIndex++]);

        // If this node is a leaf node, return
        if (l == h || preIndex >= pre.length)
            return root;

        // Find next preorder element in postorder
        int i;
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preIndex])
                break;
        }

        // Construct left and right subtrees
        if (i <= h) {
            root.left = construct(pre, post, l, i);
            root.right = construct(pre, post, i + 1, h - 1);
        }

        return root;
    }
}
