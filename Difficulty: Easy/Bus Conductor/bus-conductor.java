class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);

        int moves = 0;
        for (int i = 0; i < chairs.length; i++) {
            moves += Math.abs(chairs[i] - passengers[i]);
        }
        return moves;
    }
}
