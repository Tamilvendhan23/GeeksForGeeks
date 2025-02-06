//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) m.put(inorder[i], i);
        int[] idx = new int[1];
        return build(0, inorder.length - 1, preorder, m, idx);
    }
    static Node build(int l, int r, int[] pre, HashMap<Integer, Integer> m, int[] idx) {
        if(l > r) return null;
        Node root = new Node(pre[idx[0]++]);
        root.left = build(l, m.get(root.data) - 1, pre, m, idx);
        root.right = build(m.get(root.data) + 1, r, pre, m, idx);
        return root;
    }
}