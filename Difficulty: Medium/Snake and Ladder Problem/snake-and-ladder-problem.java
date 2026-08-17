import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int last = n * n;

        // jump[i] stores the destination after landing on cell i.
        // If there is no snake or ladder, jump[i] remains i.
        int[] jump = new int[last + 1];

        for (int i = 1; i <= last; i++) {
            jump[i] = i;
        }

        // Store ladders
        for (int i = 0; i + 1 < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Store snakes
        for (int i = 0; i + 1 < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[last + 1];
        Queue<int[]> queue = new ArrayDeque<>();

        // {current cell, number of throws}
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cell = current[0];
            int throwsCount = current[1];

            if (cell == last) {
                return throwsCount;
            }

            for (int dice = 1; dice <= 6 && cell + dice <= last; dice++) {
                int next = cell + dice;

                // A snake or ladder is taken immediately
                next = jump[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}