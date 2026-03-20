class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;
        
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;          // possible predecessor
                curr = curr.right;
            } else if (curr.data > key) {
                suc = curr;          // possible successor
                curr = curr.left;
            } else {
                // key found
                
                // find predecessor (max in left subtree)
                if (curr.left != null) {
                    Node temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre = temp;
                }
                
                // find successor (min in right subtree)
                if (curr.right != null) {
                    Node temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc = temp;
                }
                
                break;
            }
        }
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        return ans;
    }
}