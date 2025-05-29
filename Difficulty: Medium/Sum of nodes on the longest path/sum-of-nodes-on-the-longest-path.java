/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    // Helper class to store result
    class Result {
        int maxLen = 0;
        int maxSum = 0;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result res = new Result();
        dfs(root, 0, 0, res);
        return res.maxSum;
    }

    private void dfs(Node node, int currLen, int currSum, Result res) {
        if (node == null) return;

        currLen += 1;
        currSum += node.data;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            if (currLen > res.maxLen) {
                res.maxLen = currLen;
                res.maxSum = currSum;
            } else if (currLen == res.maxLen) {
                res.maxSum = Math.max(res.maxSum, currSum);
            }
            return;
        }

        dfs(node.left, currLen, currSum, res);
        dfs(node.right, currLen, currSum, res);
    }
}
