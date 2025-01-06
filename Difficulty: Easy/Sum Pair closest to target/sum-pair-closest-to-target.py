#User function Template for python3
class Solution:
    def sumClosest(self, arr, target):
        # If the array has less than 2 elements, return an empty array
        if len(arr) < 2:
            return []

        # Sort the array to use the two-pointer approach
        arr.sort()
        left, right = 0, len(arr) - 1
        closest_pair = []
        closest_diff = float('inf')

        while left < right:
            current_sum = arr[left] + arr[right]
            current_diff = abs(target - current_sum)

            # Update if this pair is closer to the target
            if current_diff < closest_diff:
                closest_diff = current_diff
                closest_pair = [arr[left], arr[right]]
            elif current_diff == closest_diff:
                # Choose the pair with the maximum absolute difference
                if abs(arr[left] - arr[right]) > abs(closest_pair[0] - closest_pair[1]):
                    closest_pair = [arr[left], arr[right]]

            # Move pointers based on the sum
            if current_sum < target:
                left += 1
            else:
                right -= 1

        return closest_pair




#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input().strip())
    while t > 0:
        arr = list(map(int, input().strip().split()))
        target = int(input().strip())
        ob = Solution()
        ans = ob.sumClosest(arr, target)
        if not ans:
            print("[]")
        else:
            print(*ans)
        print("~")
        t -= 1

# } Driver Code Ends