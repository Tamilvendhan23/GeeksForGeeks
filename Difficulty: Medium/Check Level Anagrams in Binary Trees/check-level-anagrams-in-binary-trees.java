/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

import java.util.*;

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            // If number of nodes at this level differs, cannot be anagrams
            if (size1 != size2) return false;

            List<Integer> level1 = new ArrayList<>(size1);
            List<Integer> level2 = new ArrayList<>(size2);

            // Process level of tree1
            for (int i = 0; i < size1; i++) {
                Node node = q1.poll();
                level1.add(node.data);
                if (node.left != null) q1.offer(node.left);
                if (node.right != null) q1.offer(node.right);
            }

            // Process level of tree2
            for (int i = 0; i < size2; i++) {
                Node node = q2.poll();
                level2.add(node.data);
                if (node.left != null) q2.offer(node.left);
                if (node.right != null) q2.offer(node.right);
            }

            if (!areLevelAnagrams(level1, level2)) {
                return false;
            }
        }

        // Both queues should be empty if trees have same number of levels
        return q1.isEmpty() && q2.isEmpty();
    }

    private boolean areLevelAnagrams(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) return false;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : b) {
            int count = freq.getOrDefault(x, 0);
            if (count == 0) return false;
            freq.put(x, count - 1);
        }

        return true;
    }
}