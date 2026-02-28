class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = arr1.length, m = arr2.length;
        int i = 0, j = m - 1;
        int minDiff = Integer.MAX_VALUE;
        int bestA = 0, bestB = 0;
        
        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);
            
            if (diff < minDiff) {
                minDiff = diff;
                bestA = arr1[i];
                bestB = arr2[j];
            }
            
            if (sum <= x) {
                i++;
            } else {
                j--;
            }
        }
        
        result.add(bestA);
        result.add(bestB);
        return result;
    }
}
