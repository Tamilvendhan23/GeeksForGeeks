import java.util.*;

class Solution {
    public int minTime(Node root, int target) {
        if (root == null) return 0;
        
        // First pass: build parent map and find target node
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);
        Node targetNode = null;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.data == target) {
                targetNode = curr;
            }
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        
        // Second pass: BFS from target, level by level, marking visited
        Set<Node> visited = new HashSet<>();
        queue.offer(targetNode);
        visited.add(targetNode);
        int time = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean hasNext = false;
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                    hasNext = true;
                }
                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                    hasNext = true;
                }
                // parent
                Node par = parentMap.get(curr);
                if (par != null && !visited.contains(par)) {
                    queue.offer(par);
                    visited.add(par);
                    hasNext = true;
                }
            }
            if (!queue.isEmpty()) {
                time++;
            }
        }
        
        return time;
    }
}
