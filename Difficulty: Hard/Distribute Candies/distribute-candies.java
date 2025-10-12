class Solution {
    int moves = 0;

    public int distCandy(Node root) {
        dfs(root);
        return moves;
    }

    private int dfs(Node root) {
        if (root == null) return 0;

        // Postorder traversal
        int left = dfs(root.left);
        int right = dfs(root.right);

        // Total moves = sum of absolute balances from children
        moves += Math.abs(left) + Math.abs(right);

        // Return current node’s net balance to parent
        return root.data + left + right - 1;
    }
}
