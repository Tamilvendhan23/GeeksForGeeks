import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();

        for (int x : arr) {
            // Keep collapsing opposite‑sign collisions from the right
            boolean currentAlive = true;

            while (currentAlive && !stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);

                // Same sign: just keep current for later
                if ((top > 0 && x > 0) || (top < 0 && x < 0)) {
                    break;
                }

                // Opposite signs
                int absTop = Math.abs(top);
                int absX   = Math.abs(x);

                if (absX > absTop) {
                    // x dominates: remove last, continue resolving with x
                    stack.remove(stack.size() - 1);
                } else if (absX == absTop) {
                    // Equal absolute values: remove last, don’t keep x
                    stack.remove(stack.size() - 1);
                    currentAlive = false;
                } else {
                    // x is weaker: discard x, keep top
                    currentAlive = false;
                }
            }

            // If x was not killed, push it
            if (currentAlive) {
                stack.add(x);
            }
        }

        return stack;
    }
}