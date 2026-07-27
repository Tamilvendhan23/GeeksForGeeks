/* Structure of Binary Tree Node
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

    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        int n = pre.length;
        preIndex = 0;

        for (int i = 0; i < n; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, n - 1, n);
    }

    private Node build(int[] pre, int l, int h, int n) {

        if (preIndex >= n || l > h)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == h)
            return root;

        int i = map.get(pre[preIndex]);

        root.left = build(pre, i, h, n);
        root.right = build(pre, l + 1, i - 1, n);

        return root;
    }
}