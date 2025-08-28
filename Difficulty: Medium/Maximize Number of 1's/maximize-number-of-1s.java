class Solution {
    public int maxOnes(int arr[], int k) {
        int maxLen = 0, left = 0, zeros = 0;
        int n = arr.length;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) zeros++;
            while (zeros > k) {
                if (arr[left] == 0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
