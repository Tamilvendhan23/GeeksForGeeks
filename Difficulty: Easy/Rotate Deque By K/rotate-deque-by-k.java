class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;
        k = k % n; // Normalizing k
        
        if (k == 0) return;

        if (type == 1) {
            // Right rotate: move last k elements to front
            for (int i = 0; i < k; i++) {
                int val = dq.removeLast();
                dq.addFirst(val);
            }
        } else if (type == 2) {
            // Left rotate: move first k elements to back
            for (int i = 0; i < k; i++) {
                int val = dq.removeFirst();
                dq.addLast(val);
            }
        }
    }
}
