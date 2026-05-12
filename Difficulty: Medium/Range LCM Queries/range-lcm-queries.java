import java.util.*;

class Solution {
    private long[] tree;
    private int n;
    
    private long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }
    
    private long lcm(long a, long b, long c) {
        return lcm(lcm(a, b), c);
    }
    
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }
    
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid)
            update(2 * node, start, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }
    
    private long query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 1;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        long p1 = query(2 * node, start, mid, l, r);
        long p2 = query(2 * node + 1, mid + 1, end, l, r);
        return lcm(p1, p2);
    }
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        tree = new long[4 * n];
        build(arr, 1, 0, n - 1);
        
        ArrayList<Long> result = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                // Update
                update(1, 0, n - 1, q[1], q[2]);
            } else {
                // Query
                result.add(query(1, 0, n - 1, q[1], q[2]));
            }
        }
        return result;
    }
}