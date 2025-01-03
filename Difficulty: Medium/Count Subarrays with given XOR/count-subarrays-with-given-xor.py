class Solution:
    def subarrayXor(self, arr, k):
        # Dictionary to store the frequency of prefix XORs
        xor_count = {}
        # Initialize XOR of the subarray and the count of subarrays
        xor_sum = 0
        count = 0
        
        for num in arr:
            # Update the XOR of the current subarray
            xor_sum ^= num
            
            # If the current XOR is equal to k, increment the count
            if xor_sum == k:
                count += 1
            
            # Calculate the required XOR to form a subarray with XOR == k
            required_xor = xor_sum ^ k
            
            # If required XOR exists in the hash map, add its frequency to the count
            if required_xor in xor_count:
                count += xor_count[required_xor]
            
            # Update the frequency of the current XOR in the hash map
            xor_count[xor_sum] = xor_count.get(xor_sum, 0) + 1
        
        return count


#{ 
 # Driver Code Starts
if __name__ == "__main__":
    tc = int(input())

    for _ in range(tc):
        arr = list(map(int, input().split()))
        k = int(input())

        obj = Solution()
        print(obj.subarrayXor(arr, k))
        print("~")

# } Driver Code Ends