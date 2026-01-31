class kQueues {
    private int[] arr;
    private int[] front;
    private int[] rear;
    private int[] nextt;
    private int freeIndex;
    private int n;
    private int k;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        nextt = new int[n];
        
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }
        
        // Initialize free list
        freeIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            nextt[i] = i + 1;
        }
        nextt[n - 1] = -1;
    }

    void enqueue(int x, int i) {
        if (isFull()) {
            return;
        }
        
        int idx = freeIndex;
        freeIndex = nextt[idx];
        
        arr[idx] = x;
        
        if (isEmpty(i)) {
            front[i] = idx;
        } else {
            nextt[rear[i]] = idx;
        }
        
        rear[i] = idx;
        nextt[idx] = -1;
    }

    int dequeue(int i) {
        if (isEmpty(i)) {
            return -1;
        }
        
        int idx = front[i];
        front[i] = nextt[idx];
        
        if (front[i] == -1) {
            rear[i] = -1;
        }
        
        nextt[idx] = freeIndex;
        freeIndex = idx;
        
        return arr[idx];
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return freeIndex == -1;
    }
}
