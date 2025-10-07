/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;



class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to maintain keys in sorted order
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Start with root at HD 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            Node currNode = currPair.node;
            int hd = currPair.hd;

            // Update the map with the current node's value at current HD
            hdMap.put(hd, currNode.data);

            // Add left child with HD - 1
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, hd - 1));
            }

            // Add right child with HD + 1
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, hd + 1));
            }
        }

        // Extract the bottom view nodes from the TreeMap
        for (int val : hdMap.values()) {
            result.add(val);
        }

        return result;
    }
}
