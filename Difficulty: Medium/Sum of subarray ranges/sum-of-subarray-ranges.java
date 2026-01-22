class Solution {
    public int subarrayRanges(int[] arr) {
        long maxSum = calculateContribution(arr, false);  // sum of max over all subarrays
        long minSum = calculateContribution(arr, true);   // sum of min over all subarrays
        return (int) (maxSum - minSum);
    }

    private long calculateContribution(int[] arr, boolean findSmaller) {
        int n = arr.length;
        long sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find left boundary
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && compare(arr[stack.peek()], arr[i], findSmaller) >= 0) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // Find right boundary
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && compare(arr[stack.peek()], arr[i], findSmaller) > 0) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate contribution
        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;
            sum += (long) arr[i] * l * r;
        }
        return sum;
    }

    private int compare(int a, int b, boolean findSmaller) {
        if (findSmaller) {
            return Integer.compare(a, b);
        } else {
            return Integer.compare(b, a);
        }
    }
}
