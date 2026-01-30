class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;
        
        // Step 1: Dequeue first half and enqueue back to move second half to front
        for (int i = 0; i < half; i++) {
            q.offer(q.poll());
        }
        
        // Step 2: Dequeue second half (now front) and store in temp queue (acts like stack since FIFO but reversed by order)
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < half; i++) {
            temp.offer(q.poll());
        }
        
        // Step 3: Interleave: first from original (first half now at front), then from temp
        while (!temp.isEmpty()) {
            q.offer(q.poll());  // first half element
            q.offer(temp.poll());  // second half element
        }
    }
}
