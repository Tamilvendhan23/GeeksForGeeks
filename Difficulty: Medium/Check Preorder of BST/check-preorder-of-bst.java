class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) return true;

        int lowerBound = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int val : arr) {
            if (val < lowerBound) return false;

            while (!stack.isEmpty() && val > stack.peek()) {
                lowerBound = stack.pop();
            }

            stack.push(val);
        }

        return true;
    }
}