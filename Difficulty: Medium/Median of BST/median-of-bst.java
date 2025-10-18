class Solution {
    
    // Function to count total number of nodes in BST
    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // Helper variables for inorder traversal
    int count = 0;
    int median = 0;
    
    // Inorder traversal to find median element
    void findMedianUtil(Node root, int n) {
        if (root == null) return;
        
        findMedianUtil(root.left, n);
        
        count++;
        
        // If number of nodes is odd, take (n+1)/2
        if ((n % 2 != 0) && count == (n + 1) / 2)
            median = root.data;
        
        // If even, take (n/2)
        else if ((n % 2 == 0) && count == n / 2)
            median = root.data;
        
        findMedianUtil(root.right, n);
    }
    
    public int findMedian(Node root) {
        int n = countNodes(root);
        
        // Reset counter and median before using
        count = 0;
        median = 0;
        
        findMedianUtil(root, n);
        return median;
    }
}
