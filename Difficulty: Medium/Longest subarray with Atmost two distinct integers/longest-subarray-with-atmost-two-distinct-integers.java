class Solution {
    public int totalElements(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < arr.length; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            
            while (freq.size() > 2) {
                int count = freq.get(arr[left]);
                if (count == 1) {
                    freq.remove(arr[left]);
                } else {
                    freq.put(arr[left], count - 1);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
