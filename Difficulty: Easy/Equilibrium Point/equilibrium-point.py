# User function Template for python3

class Solution:
    #Function to find equilibrium point in the array.
    def findEquilibrium(self, arr):
        # code here
        total_sum = sum(arr)
        left_sum = 0
        
        for i in range(len(arr)):
            # Calculate the right sum as total_sum - arr[i] - left_sum
            if left_sum == total_sum - arr[i] - left_sum:
                return i  # Return the equilibrium index
            left_sum += arr[i]  # Update the left sum
        
        return -1

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import math


def main():
    T = int(input())
    while (T > 0):

        arr = [int(x) for x in input().strip().split()]

        ob = Solution()

        print(ob.findEquilibrium(arr))
        print("~")
        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends