/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        // List to store levels of leaf nodes
        java.util.ArrayList<Integer> leafLevels = new java.util.ArrayList<>();

        // BFS to find leaf levels
        java.util.Queue<NodeWithLevel> queue = new java.util.LinkedList<>();
        queue.add(new NodeWithLevel(root, 1)); // root is at level 1

        while (!queue.isEmpty()) {
            NodeWithLevel current = queue.poll();
            Node node = current.node;
            int level = current.level;

            // If it's a leaf node
            if (node.left == null && node.right == null) {
                leafLevels.add(level);
            } else {
                if (node.left != null) {
                    queue.add(new NodeWithLevel(node.left, level + 1));
                }
                if (node.right != null) {
                    queue.add(new NodeWithLevel(node.right, level + 1));
                }
            }
        }

        // Sort leaf levels to pick cheapest first
        java.util.Collections.sort(leafLevels);

        int count = 0;
        int totalCost = 0;

        for (int level : leafLevels) {
            if (totalCost + level <= k) {
                totalCost += level;
                count++;
            } else {
                break; // can't afford more
            }
        }

        return count;
    }

    // Helper class to keep track of node and its level during BFS
    private static class NodeWithLevel {
        Node node;
        int level;

        NodeWithLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}