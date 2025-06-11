class Solution {
    public int findLength(int[] color, int[] radius) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < color.length; i++) {
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] == color[i] && top[1] == radius[i]) {
                    stack.pop(); // remove matching pair
                    continue;
                }
            }
            stack.push(new int[]{color[i], radius[i]});
        }

        return stack.size(); // number of balls remaining
    }
}
