import java.util.*;
class Solution {
    // Function to compute factorial values up to num
    static ArrayList<Integer> computeFact(int num) {
        ArrayList<Integer> fact = new ArrayList<>(Collections.nCopies(num + 1, 1));
        for (int i = 1; i <= num; i++)
            fact.set(i, fact.get(i - 1) * i);
        return fact;
    }

    // Function to compute nth Catalan number using precomputed factorials
    static int catalan(int n, ArrayList<Integer> fact) {
        return fact.get(2 * n) / (fact.get(n) * fact.get(n + 1));
    }

    // Function to count number of BSTs for each element as root
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        int[][] sorted = new int[n][2];

        // Pair each element with its original index and sort by value
        for (int i = 0; i < n; i++) {
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));

        ArrayList<Integer> fact = computeFact(2 * n);
        ArrayList<Integer> numBSTs = new ArrayList<>(Collections.nCopies(n, 0));

        // Compute BST count for each element as root
        for (int i = 0; i < n; i++) {
            int j = sorted[i][1];
            numBSTs.set(j, catalan(i, fact) * catalan(n - i - 1, fact));
        }

        return numBSTs;
    }
}
