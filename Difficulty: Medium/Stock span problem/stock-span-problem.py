#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
class Solution:
    def calculateSpan(self, arr):
        #write code here
        n = len(arr)
        span = [0] * n
        stack = []  # Stack to store indices
    
        for i in range(n):
            # Pop elements from stack while stack is not empty and top element is smaller than arr[i]
            while stack and arr[stack[-1]] <= arr[i]:
                stack.pop()
    
            # If stack is empty, all elements before i are smaller, so span is (i+1)
            if not stack:
                span[i] = i + 1
            else:
                span[i] = i - stack[-1]  # Difference between current index and last greater element's index
    
            stack.append(i)  # Push this element's index onto stack
        
        return span

#{ 
 # Driver Code Starts.
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        arr = list(map(int, input().split()))
        ob = Solution()
        ans = ob.calculateSpan(arr)
        print(*ans)
        print("~")
        t -= 1
# } Driver Code Ends