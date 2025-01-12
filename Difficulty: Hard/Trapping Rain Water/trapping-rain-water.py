
class Solution:
    def maxWater(self, arr):
        # code here
 
        if not arr:
            return 0
        
        n = len(arr)
        
        # Initialize two pointers
        left, right = 0, n - 1
        
        # Initialize variables to store the max heights
        left_max, right_max = arr[left], arr[right]
        
        water_trapped = 0
        
        while left <= right:
            if arr[left] <= arr[right]:
                # Process left side
                if arr[left] >= left_max:
                    left_max = arr[left]
                else:
                    water_trapped += left_max - arr[left]
                left += 1
            else:
                # Process right side
                if arr[right] >= right_max:
                    right_max = arr[right]
                else:
                    water_trapped += right_max - arr[right]
                right -= 1
        
        return water_trapped
 
#{ 
 # Driver Code Starts
#Initial template for Python 3

import math


def main():
    t = int(input())
    while (t > 0):

        arr = [int(x) for x in input().strip().split()]
        obj = Solution()
        print(obj.maxWater(arr))

        t -= 1
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends