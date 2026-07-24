class Solution {
private int best = 0;

public int longestConsecutive(Node root) {
if (root == null) return -1;
best = 0;
dfs(root, null, 0);
return best <= 1 ? -1 : best;
}

private void dfs(Node node, Node parent, int currLen) {
if (node == null) return;
if (parent != null && node.data == parent.data + 1) {
currLen = currLen + 1;
} else {
currLen = 1;
}
if (currLen > best) best = currLen;
dfs(node.left, node, currLen);
dfs(node.right, node, currLen);
}
}