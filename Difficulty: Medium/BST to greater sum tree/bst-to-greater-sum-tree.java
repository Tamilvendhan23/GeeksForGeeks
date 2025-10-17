/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum = 0;
    
    public static void transformTree(Node root) {
        sum = 0;  // reset before starting
        transform(root);
    }
    
    private static void transform(Node root) {
        if (root == null) return;

        // Reverse inorder traversal (Right → Root → Left)
        transform(root.right);

        int originalValue = root.data;
        root.data = sum;
        sum += originalValue;

        transform(root.left);
    }
}
