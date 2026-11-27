class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int sum = 0;
        for (ArrayList<Integer> list : adj) {
            sum += list.size();
        }
        return sum / 2;
    }
}