class Solution {
    // Helper function returns array of two values:
    // arr[0] - max sum including current node
    // arr[1] - max sum excluding current node
    private int[] solve(Node node) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = solve(node.left);
        int[] right = solve(node.right);
        
        // Include current node: node.data + exclude left + exclude right
        int include = node.data + left[1] + right[1];
        
        // Exclude current node: max of including or excluding left/right
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{include, exclude};
    }
    
    public int getMaxSum(Node root) {
        int[] res = solve(root);
        return Math.max(res[0], res[1]);
    }
}
