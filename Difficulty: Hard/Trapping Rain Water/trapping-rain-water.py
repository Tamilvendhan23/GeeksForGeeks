class Solution:
    def trappingWater(self, arr):
        n = len(arr)
        if n <= 2:
            return 0  # No water can be trapped if there are less than 3 blocks
        
        # Arrays to store the maximum height to the left and right of each block
        left_max = [0] * n
        right_max = [0] * n
        water = 0

        # Fill the left_max array
        left_max[0] = arr[0]
        for i in range(1, n):
            left_max[i] = max(left_max[i-1], arr[i])
        
        # Fill the right_max array
        right_max[n-1] = arr[n-1]
        for i in range(n-2, -1, -1):
            right_max[i] = max(right_max[i+1], arr[i])
        
        # Calculate the water trapped at each block
        for i in range(n):
            water += min(left_max[i], right_max[i]) - arr[i]
        
        return water

# Example usage
solution = Solution()

#{ 
 # Driver Code Starts
#Initial template for Python 3

import math


def main():
    t = int(input())
    while (t > 0):

        arr = [int(x) for x in input().strip().split()]
        obj = Solution()
        print(obj.trappingWater(arr))

        t -= 1
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends