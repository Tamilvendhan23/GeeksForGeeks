class Solution {
    int maxDiff(Node root) {
        int[] answer = { Integer.MIN_VALUE };
        findMin(root, answer);
        return answer[0];
    }

    private int findMin(Node node, int[] answer) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Minimum values among descendants
        int leftMin = findMin(node.left, answer);
        int rightMin = findMin(node.right, answer);

        int descendantMin = Math.min(leftMin, rightMin);

        // A node must have at least one descendant
        if (descendantMin != Integer.MAX_VALUE) {
            answer[0] = Math.max(answer[0], node.data - descendantMin);
        }

        // Minimum value in this subtree
        return Math.min(node.data, descendantMin);
    }
}