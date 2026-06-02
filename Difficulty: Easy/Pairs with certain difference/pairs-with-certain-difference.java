class Solution {
    public int sumDiffPairs(int[] arr, int k) {
       
        java.util.Arrays.sort(arr);
        
        int maxSum = 0;
        int n = arr.length;
        for (int i = n - 1; i > 0; --i) {
           if (arr[i] - arr[i - 1] < k) {
                maxSum += arr[i];
                maxSum += arr[i - 1];
                
               --i;
            }
        }
        
        return maxSum;
    }
}