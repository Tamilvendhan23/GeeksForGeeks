class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    
    private void postOrderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        
        // 1. Visit left subtree
        postOrderHelper(node.left, result);
        // 2. Visit right subtree
        postOrderHelper(node.right, result);
        // 3. Visit the root node
        result.add(node.data);
    }
}
