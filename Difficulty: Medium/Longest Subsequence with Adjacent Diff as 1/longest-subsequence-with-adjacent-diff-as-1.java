class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int num : arr) {
            int prevLen = map.getOrDefault(num - 1, 0);
            int nextLen = map.getOrDefault(num + 1, 0);
            int currLen = Math.max(prevLen, nextLen) + 1;
            map.put(num, currLen);
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}