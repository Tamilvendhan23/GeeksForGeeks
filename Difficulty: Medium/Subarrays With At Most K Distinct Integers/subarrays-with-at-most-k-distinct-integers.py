from collections import defaultdict

class Solution:
    def countAtMostK(self, arr, k):
        n = len(arr)
        freq = defaultdict(int)
        l = 0
        distinct = 0
        ans = 0

        for r in range(n):
            # include arr[r] in window
            if freq[arr[r]] == 0:
                distinct += 1
            freq[arr[r]] += 1

            # shrink window until distinct <= k
            while distinct > k:
                freq[arr[l]] -= 1
                if freq[arr[l]] == 0:
                    distinct -= 1
                l += 1

            # all subarrays ending at r with start in [l..r] are valid
            ans += (r - l + 1)

        return ans
