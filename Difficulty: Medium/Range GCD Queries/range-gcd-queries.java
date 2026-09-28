import java.util.*;

class Solution {
    private int[] tree;
    private int n;

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        n = arr.length;
        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];

            if (type == 0) {
                int left = query[1];
                int right = query[2];

                result.add(getGcd(1, 0, n - 1, left, right));
            } else {
                int index = query[1];
                int value = query[2];

                update(1, 0, n - 1, index, value);
            }
        }

        return result;
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, node * 2, start, mid);
        build(arr, node * 2 + 1, mid + 1, end);

        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
    }

    private int getGcd(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        int leftGcd = getGcd(node * 2, start, mid, left, right);
        int rightGcd = getGcd(node * 2 + 1, mid + 1, end, left, right);

        return gcd(leftGcd, rightGcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}