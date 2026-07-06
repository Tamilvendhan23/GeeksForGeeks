class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;

        long sumA = 0;  // use long if you worry about overflow
        long sumB = 0;
        long result = 0;

        // Traverse both arrays
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                sumA += a[i];
                i++;
            } else if (a[i] > b[j]) {
                sumB += b[j];
                j++;
            } else {
                // a[i] == b[j]: common point, choose max path so far
                result += Math.max(sumA, sumB) + a[i];
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of a[]
        while (i < n1) {
            sumA += a[i];
            i++;
        }

        // Add remaining elements of b[]
        while (j < n2) {
            sumB += b[j];
            j++;
        }

        // Add the max of the remaining sums
        result += Math.max(sumA, sumB);

        // Problem expects int; arrays constraints are modest, so cast is safe
        return (int) result;
    }
}