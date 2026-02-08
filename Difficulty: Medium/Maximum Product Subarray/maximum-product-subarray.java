class Solution {
    int maxProduct(int[] arr) {
        if (arr.length == 0) return 0;
        
        int currMax = arr[0];
        int currMin = arr[0];
        int maxProd = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int tempMax = Math.max(arr[i], Math.max(arr[i] * currMax, arr[i] * currMin));
            currMin = Math.min(arr[i], Math.min(arr[i] * currMax, arr[i] * currMin));
            currMax = tempMax;
            maxProd = Math.max(maxProd, currMax);
        }
        return maxProd;
    }
}
