class Solution {
    // Helper function to check allocation possibility with current max limit
    private boolean isPossible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;
        
        for (int pages : arr) {
            if (pages > maxPages) return false; 
            
            if (currentSum + pages > maxPages) {
                studentsRequired++;
                currentSum = pages;
                
                if (studentsRequired > k)
                    return false;
            } else {
                currentSum += pages;
            }
        }
        return true;
    }
    
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; 
        
        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // minimum possible max
            high += pages;              // sum of all pages = maximum possible max
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1;  // Increase allowed maximum
            }
        }
        return result;
    }
}
