class Solution {
    
    // Counts number of subarrays with sum <= x
    private long countAtMost(int[] arr, long x) {
        if (x < 0) return 0;
        long count = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > x && left <= right) {
                sum -= arr[left];
                left++;
            }
            // All subarrays ending at 'right' and starting from [left..right] are valid
            count += (right - left + 1);
        }
        return count;
    }
    
    public int countSubarray(int[] arr, int l, int r) {
        long ans = countAtMost(arr, r) - countAtMost(arr, l - 1);
        return (int) ans;
    }
}