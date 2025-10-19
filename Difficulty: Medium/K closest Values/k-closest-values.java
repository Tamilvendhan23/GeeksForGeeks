

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : b[0] - a[0] // max heap
        );
        
        for (int val : inorderList) {
            int diff = Math.abs(val - target);
            pq.offer(new int[]{diff, val});
            if (pq.size() > k) pq.poll();
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }
    
    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
