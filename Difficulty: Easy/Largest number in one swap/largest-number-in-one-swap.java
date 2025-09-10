class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Store the last index of each character (digits 0–9 if only numbers)
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[arr[i] - '0'] = i;
        }

        // Traverse string and find the first place where a swap helps
        for (int i = 0; i < n; i++) {
            // Try bigger digits than current one
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (lastIndex[d] > i) { // found a larger digit later
                    // swap
                    char temp = arr[i];
                    arr[i] = arr[lastIndex[d]];
                    arr[lastIndex[d]] = temp;

                    return new String(arr);
                }
            }
        }

        return s; // no swap improves
    }
}
