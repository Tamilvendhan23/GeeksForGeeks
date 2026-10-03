import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int total = 8 * n * n;
        int rowJump = 4 * n;

        ArrayList<Integer> coil1 = new ArrayList<>();
        coil1.add(1);

        int curr = 1;

        // First move: down (4n - 1) times
        int down = 4 * n - 1;
        for (int i = 0; i < down; i++) {
            curr += rowJump;
            coil1.add(curr);
        }

        // Then pairs of equal-length moves: right, up, left, down, ...
        int len = 4 * n - 2;
        int dir = 1; // 1 = right, 2 = up, 3 = left, 0 = down

        while (coil1.size() < total) {
            for (int i = 0; i < len; i++) {
                curr = move(curr, dir, rowJump);
                coil1.add(curr);
            }
            dir = (dir + 1) % 4;

            for (int i = 0; i < len; i++) {
                curr = move(curr, dir, rowJump);
                coil1.add(curr);
            }
            dir = (dir + 1) % 4;

            len -= 2;
        }

        ArrayList<Integer> coil2 = new ArrayList<>();
        for (int x : coil1) {
            coil2.add(16 * n * n + 1 - x);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(coil1);
        ans.add(coil2);
        return ans;
    }

    private int move(int curr, int dir, int rowJump) {
        switch (dir) {
            case 0: return curr + rowJump;  // down
            case 1: return curr + 1;        // right
            case 2: return curr - rowJump;  // up
            default: return curr - 1;       // left
        }
    }
}