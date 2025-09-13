class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Arrays.sort(x);         // Sort both arrays to process in descending order
        Arrays.sort(y);

        int hCount = 1;         // Number of horizontal pieces
        int vCount = 1;         // Number of vertical pieces
        int i = x.length - 1;   // Pointer for vertical cuts
        int j = y.length - 1;   // Pointer for horizontal cuts
        int totalCost = 0;

        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                totalCost += x[i] * hCount;
                vCount++;
                i--;
            } else {
                totalCost += y[j] * vCount;
                hCount++;
                j--;
            }
        }
        // Add any remaining cuts
        while (i >= 0) {
            totalCost += x[i] * hCount;
            vCount++;
            i--;
        }
        while (j >= 0) {
            totalCost += y[j] * vCount;
            hCount++;
            j--;
        }

        return totalCost;
    }
}
