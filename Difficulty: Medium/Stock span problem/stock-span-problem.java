class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> spans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>(); // stores indices
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            spans.add(span);
            stack.push(i);
        }
        return spans;
    }
}
