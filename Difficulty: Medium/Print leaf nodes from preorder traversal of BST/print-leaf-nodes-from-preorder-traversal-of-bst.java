class Solution {

    // Function to find leaf nodes from the 
    // preorder traversal
    static ArrayList<Integer> leafNodes(int[] preorder) {

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> leaves = new ArrayList<>();
        int n = preorder.length;

        // Iterate through the preorder array
        for (int i = 0, j = 1; j < n; i++, j++) {
            boolean found = false;

            // Push current node if it's greater than the next
            if (preorder[i] > preorder[j]) {
                s.push(preorder[i]);
            } else {
                // Pop elements from stack until the next value is
                // less than or equal to top
                while (!s.isEmpty()) {
                    if (preorder[j] > s.peek()) {
                        s.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }

            // If a leaf node is found, add it to result
            if (found) {
                leaves.add(preorder[i]);
            }
        }

        // Add the last element, it's always a leaf in BST preorder
        leaves.add(preorder[n - 1]);

        return leaves;
    }
}