#User function Template for python3
class Solution:
    def kthMissing(self, arr, k):
        missing_count = 0
        current = 1
        index = 0

        while missing_count < k:
            if index < len(arr) and arr[index] == current: # If the current number exists in arr, move to the next number in arr
                index += 1
            else:
                # If the current number is missing, increment the missing count
                missing_count += 1
                if missing_count == k:
                    return current
            # Move to the next number
            current += 1



#{ 
 # Driver Code Starts
#Initial Template for Python 3

#Main
if __name__ == '__main__':
    t = int(input())
    while t:
        t -= 1
        A = [int(x) for x in input().strip().split()]
        nd = [int(x) for x in input().strip().split()]
        D = nd[0]
        ob = Solution()
        ans = ob.kthMissing(A, D)
        print(ans)
        print("~")

# } Driver Code Ends