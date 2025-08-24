class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        if (m * k > n) return -1; // not enough flowers
        
        int left = 1, right = 0;
        for (int day : arr) right = Math.max(right, day);
        int answer = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMake(arr, k, m, mid)) {
                answer = mid;
                right = mid - 1; // try earlier day
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    // Helper: can we make m bouquets at or before 'day'
    private boolean canMake(int[] arr, int k, int m, int day) {
        int bouquets = 0, flowers = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // adjacent only!
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
