import java.util.*;

class SpecialQueue {
    private Queue<Integer> q;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;

    public SpecialQueue() {
        q = new LinkedList<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        q.offer(x);

        // Maintain increasing order in minDeque
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offer(x);

        // Maintain decreasing order in maxDeque
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offer(x);
    }

    public void dequeue() {
        if (q.isEmpty()) return;
        int val = q.poll();

        if (!minDeque.isEmpty() && minDeque.peekFirst() == val) {
            minDeque.pollFirst();
        }
        if (!maxDeque.isEmpty() && maxDeque.peekFirst() == val) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        return q.peek();
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }
}
