class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int maxIdx = n - 1;
        int left = -1, right = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            } else if (arr[i] < arr[maxIdx]) {
                left = i;
                right = maxIdx;
            }
        }

        if (left != -1) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        return new String(arr);
    }
}