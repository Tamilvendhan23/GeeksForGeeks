class Solution {
    public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            
            // Update max area if current area is greater
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer pointing to the shorter line
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
