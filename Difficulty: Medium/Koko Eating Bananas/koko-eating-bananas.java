class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1, right = 0;
        for (int bananas : arr) {
            right = Math.max(right, bananas);
        }
        
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(arr, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canEatAll(int[] arr, int k, int speed) {
        int hours = 0;
        for (int bananas : arr) {
            hours += (bananas + speed - 1) / speed; // same as ceil(bananas / speed)
        }
        return hours <= k;
    }
}
