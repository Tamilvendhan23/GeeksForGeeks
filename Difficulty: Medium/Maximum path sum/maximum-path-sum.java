class Solution {
    // Helper class to allow updating max value during recursion
    static class Result {
        int val;
        Result(int val) {
            this.val = val;
        }
    }
    
    int findMaxSum(Node root) {
        Result res = new Result(Integer.MIN_VALUE); // Initialize to lowest possible value
        findMaxUtil(root, res);
        return res.val;
    }
    
    // Helper recursive function to calculate max path sum for subtree rooted at 'node'
    int findMaxUtil(Node node, Result res) {
        if (node == null) 
            return 0;
        
        // Recursively get the max path sum of left and right subtrees
        int left = Math.max(0, findMaxUtil(node.left, res)); // Ignore negative paths
        int right = Math.max(0, findMaxUtil(node.right, res));
        
        // 'max at node' is node's value + left path + right path
        int maxAtNode = node.data + left + right;
        
        // Update result if maxAtNode is greater than current result
        res.val = Math.max(res.val, maxAtNode);
        
        // Return max sum path that can be extended to parent
        return node.data + Math.max(left, right);
    }
}
