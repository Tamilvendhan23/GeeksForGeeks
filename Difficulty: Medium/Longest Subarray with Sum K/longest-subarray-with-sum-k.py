class Solution:
    def longestSubarray(self, arr, k):
        prefix_map = {}  # To store prefix_sum and its first occurrence index
        prefix_sum = 0
        max_length = 0

        for i, num in enumerate(arr):
            prefix_sum += num

            # If the prefix_sum itself is equal to k
            if prefix_sum == k:
                max_length = max(max_length, i + 1)

            # If prefix_sum - k exists, update the max_length
            if (prefix_sum - k) in prefix_map:
                max_length = max(max_length, i - prefix_map[prefix_sum - k])

            # Store prefix_sum in the hashmap if not already stored
            if prefix_sum not in prefix_map:
                prefix_map[prefix_sum] = i
        return (max_length)
 

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input().strip())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        k = int(input().strip())
        ob = Solution()
        print(ob.longestSubarray(arr, k))
        tc -= 1
        print("~")
# } Driver Code Ends