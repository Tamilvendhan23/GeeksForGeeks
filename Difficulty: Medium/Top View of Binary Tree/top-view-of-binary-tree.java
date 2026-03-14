class Solution {
    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}