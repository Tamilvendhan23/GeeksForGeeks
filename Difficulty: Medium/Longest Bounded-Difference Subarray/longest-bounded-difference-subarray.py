class Solution:
    def longestSubarray(self, arr, x):
        if not arr:
            return []
        
        n = len(arr)
        if n == 1:
            return arr
            
        # Initialize window parameters
        max_length = 1
        start_idx = 0
        window_min = arr[0]
        window_max = arr[0]
        left = 0
        
        # Single pass with sliding window
        for right in range(1, n):
            # Update window min and max
            window_min = min(window_min, arr[right])
            window_max = max(window_max, arr[right])
            
            # Check if current window is valid
            while window_max - window_min > x:
                # Shrink window from left
                left += 1
                # Update min and max based on remaining elements
                window_min = min(arr[left:right + 1])
                window_max = max(arr[left:right + 1])
            
            # Update result if current window is longer
            curr_length = right - left + 1
            if curr_length > max_length:
                max_length = curr_length
                start_idx = left
        
        return arr[start_idx:start_idx + max_length]


#{ 
 # Driver Code Starts
#Initial Template for Python
if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        k = int(input().strip())
        ob = Solution()
        ans = ob.longestSubarray(arr, k)

        print(" ".join(map(str, ans)))
        tc -= 1
        print("~")

# } Driver Code Ends
